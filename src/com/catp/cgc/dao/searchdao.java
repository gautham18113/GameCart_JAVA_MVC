package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.catp.cgc.vo.*;
public class searchdao {

	public ArrayList<searchto> validate(searchto to)
	{
		Connection con= null;
		ArrayList<searchto> l=new ArrayList<searchto>();
		
		java.sql.Statement ps=null;
		Statement st=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/cgc";
			String user = "root";
			String psw = "root";
			con = DriverManager.getConnection(url,user,psw);
			String sql = "SELECT game_type,company FROM game_registration";
			ps=con.createStatement();
			ResultSet rs = null;
			rs=ps.executeQuery(sql);
			while(rs.next())
			{
				searchto to1=new searchto();
				to1.setGame_type(rs.getString("game_type"));
				to1.setCompany(rs.getString("company"));
				l.add(to1);
				
			}
			
			
			
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return l ;
			
	}
}
