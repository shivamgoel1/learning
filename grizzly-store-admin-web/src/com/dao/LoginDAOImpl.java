package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConnectionManager;

public class LoginDAOImpl implements LoginDAO{

	ConnectionManager manager=null;
	
	public LoginDAOImpl() {
		// TODO Auto-generated constructor stub
		manager=new ConnectionManager();
	}
	
	@Override
	public void showLoginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	public boolean validateUser(String username, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con =manager.connect();
		
		String sql= "select username and password from admin where username= ? and password=?";
		PreparedStatement statement =con.prepareStatement(sql);
		statement.setString(1,username);
		statement.setString(2,password);
		
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
			return true;
		}
		else
		return false;
	}

}
