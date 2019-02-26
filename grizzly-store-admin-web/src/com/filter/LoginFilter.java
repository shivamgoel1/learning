package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAOImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/Product")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	HttpSession session;
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//PrintWriter out=response.getWriter();
		LoginDAOImpl impl=new LoginDAOImpl();
		String password=request.getParameter("psw");
		String username=request.getParameter("uname");
		
		boolean flag=false;
		
		try {
			flag=impl.validateUser(username, password);
			if(flag==true){
				System.out.print("Valid User");
				chain.doFilter(request, response);
			}
			else{
				RequestDispatcher rq= request.getRequestDispatcher("index.jsp");
				PrintWriter pw=response.getWriter();
			//	String html="";
//				pw.write("Window.alert('\'Hello! I am an alert box!!'\')");
//				session.setAttribute("Login_Expired","Expired");
				rq.include(request, response);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
