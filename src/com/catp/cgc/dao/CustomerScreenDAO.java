package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.catp.cgc.vo.*;


public class CustomerScreenDAO {
	public String customerScreen(CustomerScreenBean csb)
	{
		String sid="";
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con;
				con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cgc", "root",
					"root");
			PreparedStatement ps=con.prepareStatement
			("select playerid,playerpassword from player_id_generation where playerid=? and playerpassword=?");
			ps.setString(1,csb.getPlayerID());
			ps.setString(2,csb.getPassword());
			String cid=csb.getPlayerID();
			
			ResultSet rs=ps.executeQuery();
			System.out.println("Done");
			if(rs.next())
			{
			sid=generateNum(cid);
			}
			else
			{
				sid="";
				System.out.println("2");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("sid"+sid);
		return sid;
		
	}

	private String generateNum(String cid) {
		// TODO Auto-generated method stub
		String sid="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cgc", "root",
					"root");
			PreparedStatement ps1=con.prepareStatement
			("select count(suggestid) from feedbackdetails;");
			ResultSet rs=ps1.executeQuery();
			int suggestid=0;
			if(rs.next())
			{
				int s=Integer.parseInt(rs.getString(1));
				if(s==0)
				{
					sid="S001";
				}
				else
				{
					if(s<=9)
					{
						suggestid=s+1;
						sid="S00"+suggestid;
					}
					else if(s<=98)
					{
						suggestid=s+1;
						sid="S0"+suggestid;
					}
					else if(s<=998)
					{
						suggestid=s+1;
						sid="S"+suggestid;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sid;
	}

}
