package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAOImpl;
import com.model.product.Product;

public class ProductServiceImpl implements ProductService{

	
	ProductDAOImpl daoImpl=null;
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		daoImpl=new ProductDAOImpl();
	}
	public void showList(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
	 List<Product> list = new ArrayList<Product>();
	 
	 list=daoImpl.listProduct();
	 System.out.println(list);
		RequestDispatcher rq= request.getRequestDispatcher("product.jsp");
		request.setAttribute("product", list);
		rq.forward(request, response);
	 
	}
	@Override
	public void showAddForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rq = request.getRequestDispatcher("NewProduct.jsp");
		rq.forward(request, response);
		
	}
	@Override
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result= daoImpl.addProduct(request, response);
		if(result==1){
			RequestDispatcher rq = request.getRequestDispatcher("/Product");
			rq.forward(request, response);
		}
		else{
			RequestDispatcher rq = request.getRequestDispatcher("NewProduct.jsp");
			rq.forward(request, response);
		}
	}
	@Override
	public void removeProduct(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		int result=daoImpl.removeProduct(id);
		if(result==1){
			RequestDispatcher rq = request.getRequestDispatcher("/Product");
			rq.forward(request, response);
		}else{
			RequestDispatcher rq = request.getRequestDispatcher("NewProduct.jsp");
			rq.forward(request, response);
		}
		
		
	}
	@Override
	public void View(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		 System.out.println(id);
		 List<Product> list = new ArrayList<Product>();
		 
		 list=daoImpl.View(id);
		 System.out.println(list);
			RequestDispatcher rq= request.getRequestDispatcher("View.jsp");
			request.setAttribute("description", list);
			rq.forward(request, response);
		 
		
	}
	

}
