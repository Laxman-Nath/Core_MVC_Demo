package com.mvc.repositry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
  public static Connection getConnection() {
	  Connection conn=null;
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","siddha@123");
		  
	  }
	  catch(ClassNotFoundException e) {
		  System.out.println(e);
	  }
	  catch(SQLException e) {
		  System.out.println(e);
	  }
	  return conn;
  }
  
}
