package org.lujx.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Configuration config;

	private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);

	static {
		config = new Configuration().configure();

//		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		sessionFactory = config.buildSessionFactory();
	}

	/**
	 * 
	 * @Description: 获得session工厂
	 * @param @return
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {

		if(sessionFactory==null){
			LOGGER.error("the SessionFactory is null");
			return null;
		}
		
		return sessionFactory;
	}
	
	
	/**
	 * 
	 * @Description: TODO
	 * @param @param entityClass
	 * @param @param proc
	 * @param @param objects
	 * @param @return 
	 * @return List<T>
	 */
	public static <T> List<T>  dbProcQuery(Class<T> entityClass, String proc, Object...objects) {
		// TODO Auto-generated method stub
		Session s =HibernateUtil.getSessionFactory().openSession();
		
		StringBuffer sb = new StringBuffer();
		
		for (Object o : objects) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append("?");
		}
		
		SQLQuery q1 = s.createSQLQuery(
				String.format("exec %s %s", proc, sb.toString()));
		int index = 0;
		
		for (Object o : objects) {
			q1.setParameter(index++, o);
		}
		q1.addEntity(entityClass);
		return q1.list();
	}
	
	
	/**
	 * 
	 * @Description: TODO
	 * @param @param entityClass
	 * @param @param proc
	 * @param @return 
	 * @return List<T>
	 */
	public static <T> List<T>  dbProcQuery(Class<T> entityClass, String proc) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		StringBuffer sb = new StringBuffer();
		
		
		SQLQuery q1 = s.createSQLQuery(
				String.format("%s", proc));
		
		q1.addEntity(entityClass);
		return q1.list();
	}
	

}
