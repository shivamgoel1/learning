package com.Dao;
import java.util.*;
import com.model.*;
import java.sql.SQLException;

public interface BookDao {
	public void connect() throws SQLException;
	public List<Book> listBook() throws SQLException;
	public int updateBook(Book b)throws SQLException;
	public int deleteBook(Book b)throws SQLException;
	public int insertBook(Book b)throws SQLException;
	public void disconnect() throws SQLException;
	
}
