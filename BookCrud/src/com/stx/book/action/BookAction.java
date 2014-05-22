package com.stx.book.action;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.stx.book.dao.BookDao;
import com.stx.book.model.Book;

/**
 * 图书Action类
 * 
 * @author getan
 * 
 */
public class BookAction extends ActionSupport {
	// 图书编号(接收url参数传递用)
	private String isbn;
	// 图书编号(用于一次删除多本图书用)
	private String[] isbns;
	// 图书对象(新增及编辑图书用)
	private Book book;
	// 图书列表(查询图书用)
	private Collection<Book> books;

	// 获取图书Dao对象(此次为模拟Dao，创建Dao对象的方式不同于平常)
	private BookDao dao = BookDao.getInstance();

	/**
	 * 根据编号获得对应的图书对象并加载至页面
	 * 
	 * @return
	 */
	public String load() {
		book = dao.getBook(isbn);
		return SUCCESS;
	}

	/**
	 * 获得所有的图书对象并显示至页面
	 * 
	 * @return
	 */
	public String list() {
		books = dao.getBooks();
		return SUCCESS;
	}

	/**
	 * 保存图书对象(新增、修改图书用)
	 * 
	 * @return
	 */
	public String store() {
		dao.storeBook(book);
		return SUCCESS;
	}

	/**
	 * 根据图书编号(或多个图书编号)删除图书
	 * 
	 * @return
	 */
	public String remove() {
		// 单个图书情况(操作中删除方式)
		if (null != isbn) {
			dao.removeBook(isbn);
		} else {// 多本图书情况(选择框删除方式)
			dao.removeBooks(isbns);
		}
		return SUCCESS;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String[] getIsbns() {
		return isbns;
	}

	public void setIsbns(String[] isbns) {
		this.isbns = isbns;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
}