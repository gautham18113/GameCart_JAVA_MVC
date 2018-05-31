package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.catp.cgc.vo.loginBean;

public class LoginDAO {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("LoginController");
	public static boolean connect(loginBean b) throws SQLException, ClassNotFoundException
	{
		LOG.info("came into LoginDAO");
		System.out.println("came");
	Class.forName("com.mysql.jdbc.Driver");
	
	
	String url="jdbc:mysql://localhost/cgc";
	 ResultSet rs=null;
	   Connection con=DriverManager.getConnection(url,"root","root");
	   String qry="select * from  admin";
	   PreparedStatement statement=con.prepareStatement(qry);
	     rs= statement.executeQuery();
	  
	 String s1=b.getAdminid();
	 String s2=b.getPassword();
	   String ss=null;
	   
	    String ss1=null;
	    while(rs.next())
	    {
	     ss=rs.getString("username");
	    
	     ss1=rs.getString("password");
	    System.out.println(ss1);
	    
	     if((ss.equals(s1)&&(ss1.equals(s2))))
	       {

	      return true;
	       }/*else
	       {
	    	   return false;
	       }*/
	     

	

}
		return false;
	}
}