package com.stx.book.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.stx.book.model.Book;

/**
 * 图书Dao类(模拟数据库访问)
 * 
 * @author getan
 *
 */
public class BookDao {
    private static final BookDao instance;
    private static final ConcurrentMap<String, Book> data;
    
    static {
        instance = new BookDao();
        data = new ConcurrentHashMap<String, Book>();
        // 模拟数据库数据
        data.put("978-0000000008", new Book("978-0000000008", "JAVA编程思想", 32.99));
        data.put("978-0000000007", new Book("978-0000000007", "Linux系统管理", 35.96));
        data.put("978-0000000001", new Book("978-0000000001", "Objective-C基础教程", 43.19));
        data.put("978-0000000002", new Book("978-0000000002", "J2EE权威指南", 25.19));
        data.put("978-0000000003", new Book("978-0000000003", "大型网站技术架构", 28.99));
    }
    
    private BookDao() {}
    
    public static BookDao getInstance() {
        return instance;
    }
    
    public Collection<Book> getBooks() {
        return data.values();
    }
    
    public Book getBook(String isbn) {
        return data.get(isbn);
    }
    
    public void storeBook(Book book) {
        data.put(book.getIsbn(), book);
    }
        
    public void removeBook(String isbn) {
        data.remove(isbn);
    }
    
    public void removeBooks(String[] isbns) {
        for(String isbn : isbns) {
            data.remove(isbn);
        }
    }
}