package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.product.Product;

public interface ProductService {
	
	public void showList(HttpServletRequest request,HttpServletResponse response)throws ClassNotFoundException, SQLException, ServletException, IOException;
	public void showAddForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException;
	
	public void removeProduct(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException;
	public void View(HttpServletRequest request, HttpServletResponse response)throws ClassNotFoundException, SQLException, ServletException, IOException;
}
