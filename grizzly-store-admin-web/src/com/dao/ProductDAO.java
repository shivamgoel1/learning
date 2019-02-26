package com.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.product.Product;

public interface ProductDAO {
	
	public List<Product> listProduct() throws ClassNotFoundException, SQLException ,ServletException, IOException ;
	public int addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException;
	public int removeProduct(int id) throws ClassNotFoundException, SQLException;
	public  List<Product> View(int id)throws ClassNotFoundException, SQLException;
}
