package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.catp.cgc.vo.*;;

public class PlayeridDAO {
	public boolean insertValues(Player_idTO pto) throws ClassNotFoundException
	{
		boolean b=false;
		try
		{
		Connection conn = null;
		String url = "jdbc:mysql://localhost/";
		String dbName = "cgc";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "root";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("connected");
//		System.out.println("");
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=null;
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mms_demo","root","password-1");
		PreparedStatement prs=conn.prepareStatement("insert into player_id_generation(playername,playerage,playeremail,playeraddress,playercontact,playerduration,playerpassword,playergender,playeragegroup)"+"values(?,?,?,?,?,?,?,?,?)");
		prs.setString(1, pto.getPlayername());
		prs.setString(2, pto.getPlayerage());
		prs.setString(3, pto.getPlayermail());
		prs.setString(4, pto.getPlayeraddress());
		prs.setString(5, pto.getPlayercontact());
		prs.setString(6, pto.getDuration());
		prs.setString(7, pto.getPassword());
		prs.setString(8, pto.getGender());
		prs.setString(9, pto.getAgegroup());
		if(prs.executeUpdate()>0)
		{
			System.out.println("inserted");
			b=true;
		}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ikii9");
		}
		return b;
	}

}
