package com.tmp.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	public static Connection getConnection() throws Exception{
		InitialContext cxt; 
		DataSource ds = null;
		Connection con = null;
		System.out.println("getConnectionFromDS starts ... ");
		  try {
			  cxt = new InitialContext();
			  ds = (DataSource)cxt.lookup( "java:/comp/env/jdbc/tmp" );
		//	  ds = (DataSource)cxt.lookup( "java:jboss/datasources/tmp" );
			  System.out.println(" ds  " + ds);
			  con=ds.getConnection(); 
	 
			//   con = DriverManager.getConnection("jdbc:mysql://talentmanpower.com:3306/talentma_talentmanpower","talentma","T@lentMP#123"); 
		  }catch(Exception exp){
			  System.out.println("Connection Exception  " + exp);
		  }
		  System.out.println("DS Connection Object " + con);
		  return con;
	}
	
	 public static void freeResources(Connection con) throws SQLException{
	        con.close();
	    }

}
