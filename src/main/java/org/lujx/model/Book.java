/**   
 * Copyright © 2018 Copyright ©  All Right reserved
 * 
 * @Package: org.lujx.test 
 * @author: lujx   
 * @date: 2018年7月17日 下午5:11:14 
 */
package org.lujx.model;

/** 
 * @Description: TODO
 * @author: lujx
 * @date: 2018年7月17日 下午5:11:14  
 */
public class Book {
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
	private String bookAuth;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookAuth() {
		return bookAuth;
	}
	public void setBookAuth(String bookAuth) {
		this.bookAuth = bookAuth;
	}
	public Book(Integer bookId, String bookName, Double bookPrice, String bookAuth) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuth = bookAuth;
	}
	public Book(String bookName, Double bookPrice, String bookAuth) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuth = bookAuth;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookAuth="
				+ bookAuth + "]";
	}
	
}
