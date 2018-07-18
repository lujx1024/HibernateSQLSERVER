/**   
 * Copyright © 2018 Copyright ©  All Right reserved
 * 
 * @Package: org.lujx.test 
 * @author: lujx   
 * @date: 2018年7月17日 下午5:22:22 
 */
package org.lujx.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.lujx.model.Book;
import org.lujx.utils.HibSf;
import org.lujx.utils.HibernateUtil;

/**
 * @Description: TODO
 * @author: lujx
 * @date: 2018年7月17日 下午5:22:22
 */
public class ManageBook {
	private static SessionFactory sessionFactory;
	private static Logger LOGGER = Logger.getLogger(ManageBook.class);
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Test
	public void testGetALlBooks() {
			Session session = sessionFactory.openSession();
			
			Criteria criteria = session.createCriteria(Book.class);
			
			Disjunction disjunction = Restrictions.disjunction();
			
			disjunction.add(
					Restrictions.or(Restrictions.lt("bookPrice", 40.0), 
					Restrictions.like("bookName", "%的%")));			
			List list = criteria.list();
			System.err.println(list);
			session.close();
	}
	
	@Test
	public void testCallProWithoutInputParam(){
		
		Session session = sessionFactory.openSession();
		
        List<Book> list = HibernateUtil.dbProcQuery(Book.class, "Proc_GetAll_Books");
        
        for (Book book : list) {
			System.err.println(book);
		}
        
        session.close();
	}
	
	@Test
	public  void testCallProcWithInputParam(){
		Session session = sessionFactory.openSession();
		List<Book> list = HibernateUtil.dbProcQuery(Book.class, "Proc_GetAll_BooksByAuth", "金");
		
		for (Book book : list) {
			System.err.println(book);
		}
		
		session.close();
	}
	
	@Test
	public void testCallProcWithInputParamAndOutParam(){
		Session session = sessionFactory.openSession();
		String str="八";
		String callableStatement="exec  Proc_GetPrice_BooksByName( ？,?)";
		
		SQLQuery sqlQuery = session.createSQLQuery(callableStatement);
		
		sqlQuery.setParameter(1, str);
		
		
	}
}
