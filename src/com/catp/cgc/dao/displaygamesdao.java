
package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.catp.cgc.businessexception.*;
import com.catp.cgc.vo.displaygamesto;
import com.catp.cgc.vo.playto;
import com.catp.cgc.vo.searchto;

public class displaygamesdao {

	
	public List<displaygamesto> getdetails(searchto to)
	{
		List<displaygamesto>l2=new ArrayList<displaygamesto>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
			String sql="select * from game_registration where game_title='"+to.getGame_title() +"' or game_type='"+ to.getGame_type()+"' or company='"+to.getCompany() +"' ;";
				ps=con.prepareStatement(sql);
			
			ps.execute();
			rs=ps.getResultSet();
			
			while(rs.next())
			{
				System.out.println(rs.getString("game_id"));
				displaygamesto to1=new displaygamesto();
				to1.setGid(rs.getString("game_id"));
				to1.setGtitle(rs.getString("game_title"));
				to1.setGtype(rs.getString("game_type"));
				to1.setCom(rs.getString("company"));
				l2.add(to1);
				System.out.println(l2);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l2;
	}
	
	
	public boolean checkuser(playto pto) throws searchbusinessexception
	{
		int f=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String sql1="select playerpassword from player_id_generation where playerid='"+pto.getId()+"'";
		
			System.out.println("checkinguser");
		
			try {
				ps=con.prepareStatement(sql1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			rs=ps.getResultSet();
			System.out.println("rs"+rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				String pw=rs.getString("playerpassword");
				System.out.println("pw"+pw);
			String s=pto.getPwd();
			System.out.println("s="+ s);
				if(s.equals(pw))
				{
					System.out.println(s.equals(pw));
					f=1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f==1)return true;
		else
		{
		
			throw new searchbusinessexception("invalid credentials!");
		}
	}
	
	
	public boolean checktime(playto pto2) throws searchbusinessexception
	{
		int f=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql="select playerduration from player_id_generation where playerid='"+pto2.getId()+"'";
				System.out.println("checking time");
				try {
					ps=con.prepareStatement(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs=ps.getResultSet();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
					
					playto pto4=new playto();
					if(Integer.parseInt(pto4.getTime())< Integer.parseInt(rs.getString(sql)))
							{
						f=1;
							}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
if(f==1)
	return true;
else
	return false;
	}
	
	public void updatetime(playto pto5)
	{
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
			String sql="select playerduration from player_id_generation where playerid='"+pto5.getId()+"'";
			System.out.println("executed");
				ps=con.prepareStatement(sql);
			
			ps.execute();
			ResultSet rs=ps.getResultSet();
			rs.next();
			
			String sql2="update player_id_generation set playerduration='"+(Integer.parseInt(rs.getString(sql)) - Integer.parseInt(pto5.getTime()))+"' where playerid='"+pto5.getId()+"'";
ps=con.prepareStatement(sql2);
			System.out.println("difference is"+ (Integer.parseInt(rs.getString(sql)) - Integer.parseInt(pto5.getTime())));
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	
