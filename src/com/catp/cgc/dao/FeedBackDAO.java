package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.catp.cgc.vo.*;

public class FeedBackDAO {
	public boolean feedBack(FeedBackBean fb)
	{
		boolean b=false;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cgc", "root",
						"root");
System.out.println(11);
				PreparedStatement ps = con
						.prepareStatement("insert into feedbackdetails values(?,?,?,?,?,?)");

				ps.setString(1, fb.getSuggestion());
				ps.setString(2, fb.getPlayerid());
				ps.setString(3, fb.getFeedback());
				ps.setString(4, fb.getGame_title());
				ps.setString(5, fb.getVendor());
				ps.setString(6, fb.getDesc());
				if(ps.executeUpdate()>0)
					b=true;
				System.out.println("Table updated successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return b;
		}
	}

