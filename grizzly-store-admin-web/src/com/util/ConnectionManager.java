package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	Connection connection= null;
	String jdbcURL,jdbcUser,JdbcPassword,driver;
	
	public ConnectionManager(){
		jdbcURL="jdbc:mysql://localhost:3306/GrizzlyStore?useSSL=false";
		jdbcUser="root";
		JdbcPassword="root";
		driver="com.mysql.jdbc.Driver";
		System.out.print(jdbcURL+" "+jdbcUser+" "+JdbcPassword+" ");
	}
	
	public Connection connect() throws SQLException, ClassNotFoundException{
		
		if(connection == null || connection.isClosed()){
			Class.forName(driver);
			connection =  DriverManager.getConnection(jdbcURL,jdbcUser,JdbcPassword);
		}
		
		
		return connection;
	}
	
}
