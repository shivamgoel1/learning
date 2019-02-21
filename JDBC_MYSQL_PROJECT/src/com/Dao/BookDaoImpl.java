package com.Dao;
import java.sql.*;
import com.Client.*;
import java.util.*;
import com.model.*;

public class BookDaoImpl implements BookDao{

	
	String usr,pass,url;
	
	Connection con =null;
	
	public BookDaoImpl(String usr, String pass, String url) {
		super();
		this.usr = usr;
		this.pass = pass;
		this.url = url;
	}

	@Override
	public void connect() throws SQLException {
		if(con==null || con.isClosed()){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				throw new SQLException(e);
			}
			
			con =  DriverManager.getConnection(url,usr,pass);
			System.out.print(con);
		}
		
	}

	@Override
	public List<Book> listBook() throws SQLException {
		
		
		List<Book> list=new ArrayList<Book>();
		String sql="select *from book";
		connect();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next()){
			int id = rs.getInt("book_id");
			String title =rs.getString("title");
			String author=rs.getString("author");
			float price = rs.getFloat("price");
			
			Book b= new Book(id,title,author,price);
			list.add(b);
		}
		st.close();
		rs.close();
		disconnect();
		
		
		return list;
	}

	@Override
	public int insertBook(Book b) throws SQLException{
		String title,author;
		float price;
		title=b.getTitle();
		author=b.getAuthor();
		price=b.getPrice();
		String sql="insert into book (title,author,price)values(?,?,?)";
		connect();
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,title);
		ps.setString(2,author);
		ps.setFloat(3,price);
		
		int rs=ps.executeUpdate();
		ps.close();
		disconnect();
		return rs;
	}

	@Override
	public int updateBook(Book b)throws SQLException {
		
		String sql= "update table book set price=? where id =?";
		float price=b.getPrice();
		int id=b.getId();
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setFloat(1,price);
		ps.setInt(2,id);
		connect();
		int rs=ps.executeUpdate();
		ps.close();
		disconnect();
		return rs;
	}

	@Override
	public int deleteBook(Book b) throws SQLException{
		
		String sql= "delete from book where id=?";
		int id=b.getId();
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1,id);
		connect();
		int rs=ps.executeUpdate();
		ps.close();
		disconnect();
		return rs;
	}

	@Override
	public void disconnect() throws SQLException {
		// TODO Auto-generated method stub
		
		if(con!=null|| !con.isClosed()){
			con.close();
		}
		
	}
	
	
	
}
