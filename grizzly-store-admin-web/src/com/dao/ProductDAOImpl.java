package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.product.Product;
import com.util.ConnectionManager;

public class ProductDAOImpl implements ProductDAO {

	ConnectionManager manager=null;
	
	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
		manager=new ConnectionManager();
	}

	@Override
	public List<Product> listProduct() throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=manager.connect();
		
		List<Product> list=new ArrayList<Product>();
		String sql="select * from Product";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next()){
			String name=rs.getString("name");
			String brand =rs.getString("brand");
			String category=rs.getString("category");
			float rating = rs.getFloat("rating");
			int id =rs.getInt("product_id");
			
			Product product= new Product(category, name, brand, rating,id);
			list.add(product);
		}
		st.close();
		rs.close();
		
		System.out.print(list);
		return list;
		
	}
	@Override
	public int addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{
		
		Product p =new Product(request.getParameter("category"),request.getParameter("name"),
				request.getParameter("description") ,request.getParameter("brand") ,
				Float.valueOf(request.getParameter("rating")) ,Float.valueOf(request.getParameter("price"))
				);
		String category, name, description,brand;
		//int id;
		Float price,rating;
		String sql= "insert into Product(category,name,description,brand,rating,price) values(?,?,?,?,?,?)";
		category=p.getCategory();
		name=p.getName();
		description=p.getDescription();
		brand=p.getBrand();
		rating=p.getRating();
		price=p.getPrice();
		Connection con= manager.connect();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1,category);
		ps.setString(2,name);
		ps.setString(3,description);
		ps.setString(4, brand);
		ps.setFloat(5,rating);
		ps.setFloat(6, price);
		int rs = ps.executeUpdate();
		ps.close();
		con.close();
		
	return rs;
	}

	@Override
	public int removeProduct(int id) throws ClassNotFoundException, SQLException {
		Connection con= manager.connect();
		String sql="delete from Product where product_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int result = ps.executeUpdate();
		con.close();
		return result;
	}

	@Override
	public List<Product> View(int id) throws ClassNotFoundException, SQLException {
		
		Connection con=manager.connect();
		List<Product> list=new ArrayList<Product>();
	String sql="select description,price from Product where product_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			String description=rs.getString("description");
			float price=rs.getFloat("price");
			Product p= new Product(description, price);
			list.add(p);
			
		}
		
		con.close();
		rs.close();
		ps.close();
		return list;
	}
}
