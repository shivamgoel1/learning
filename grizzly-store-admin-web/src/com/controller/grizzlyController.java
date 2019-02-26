package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAOImpl;
import com.dao.ProductDAOImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

/**
 * Servlet implementation class grizzlyController
 */
//@WebServlet("/grizzlyController")
public class grizzlyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public grizzlyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    LoginDAOImpl logindaoimp= null;
    
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	logindaoimp= new LoginDAOImpl();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		PrintWriter pw= response.getWriter();
		pw.write(action);
		switch(action){
		case "/":
			System.out.print("Controller");
			logindaoimp.showLoginForm(request, response);
			break;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
