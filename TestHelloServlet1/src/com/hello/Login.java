package com.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usr = request.getParameter("uname");
		String pass = request.getParameter("psw");
		PrintWriter pw=response.getWriter();	
		ServletConfig servletConfig=getServletConfig();
		String us = servletConfig.getInitParameter("username");
		String pas = servletConfig.getInitParameter("password");
		
		String driver = servletConfig.getInitParameter("jdbc");
		String URL = servletConfig.getInitParameter("URL");
//		Cookie cookie=new Cookie("Uname",usr);
//		response.addCookie(cookie);
		
		HttpSession httpSession= request.getSession();
		httpSession.setAttribute("uname", usr);
		
		
		try {
			Class.forName(driver);
			Connection con=null;
			con = DriverManager.getConnection(URL,us,pas);
		 
		
			String SQL= "select username,password from admin";
			Statement st= null;
		
			st=con.createStatement();
		
			ResultSet rs =null;
		
		
			rs=st.executeQuery(SQL);
			int flag=1;
		
			while(rs.next()){
				
				String username =rs.getString("username");
				String password =rs.getString("password");
				
				if(usr.equals(username)&& pass.equals(password)){
					response.getWriter().append("Served at: ").append(request.getContextPath());
					pw.write("\nWelcome CAPTIAN");
					RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
					rd.forward(request,response);//go to success.jpg page
					flag=1;
					rs.close();
					con.close();
				}
				flag =0;
			}
			
			if(flag==0){
				
				ServletContext context=getServletContext();
				String cogni= context.getInitParameter("cogni");
				pw.write("<h1>"+cogni + "</h1>");			
				response.getWriter().append("Served at: ").append(request.getContextPath());
				pw.write("\nInvalid Credantials");
//				RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
//				rd.forward(request,response);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request,response);//include give msg on same page no need to refresh the page 
				rs.close();
				con.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		if(usr.equals(us)){
//			if(pass.equals(pas)){
//				response.getWriter().append("Served at: ").append(request.getContextPath());
//				pw.write("\nWelcome CAPTIAN");
//				RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
//				rd.forward(request,response);//go to success.jpg page
//				
//			}
//		}
//		else{
//			response.getWriter().append("Served at: ").append(request.getContextPath());
//			pw.write("\nInvalid Credantials");
////			RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
////			rd.forward(request,response);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request,response);//include give msg on same page no need to refresh the page 
//			
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
