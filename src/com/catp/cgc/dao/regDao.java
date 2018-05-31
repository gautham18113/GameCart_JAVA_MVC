package com.catp.cgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.SQLException;

import com.catp.cgc.vo.*;

public class regDao {
	Connection con = null;
	Statement st;
	public boolean connection(regBean b){
		boolean flag = false;
		//Connection con = null;
		String s=b.getGametype();
		PreparedStatement pst = null;
	//	Statement st;
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cgc", "root", "root");
				
				String query="select case when count(Game_id)=0 then '1' when count(Game_id)>0 then cast(cast(substring(max(Game_id),4) as unsigned int)+1 as char) end gameid from game_registration";
				pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				StringBuffer sb=new StringBuffer();
				if(rs.next())
				{
					sb.append(rs.getString("gameid"));
					if(sb.length()==1)
					{
						sb.insert(0,s.substring(0,3)+"00");
					}
				}
				pst = con.prepareStatement("insert into game_registration (game_id,game_title,company,game_releasedate,game_type,base_price,ins_date,valid_year,game_rating,Exp_date,price) values(?,?,?,?,?,?,?,?,?,?,?)");
				System.out.println("Prepared Statement");
				pst.setString(1, sb.toString());
				pst.setString(2, b.getGametitle());
				pst.setString(3, b.getCompany());
				pst.setString(4, b.getGamerelease());
				pst.setString(5, b.getGametype());
				pst.setString(6, Integer.toString(b.getGame_base_price()));
				pst.setString(7, b.getInsdate());
				pst.setString(8, ""+b.getValidyear());
				pst.setString(9, ""+(b.getGamerating()));
				pst.setString(10, b.getExp_date());
				pst.setString(11, ""+b.getPrice());
				int output = pst.executeUpdate();
				System.out.println(b.getPrice());
				System.out.println(b.getExp_date());
				if(output!=0)
				{
					flag=true;
				}

				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		return flag;

	}
	public String getDistributoriddao() throws SQLException, ClassNotFoundException
	{
		//connection con;
	ResultSet rs1=null;
	//Statement st;
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
	st=(Statement) con.createStatement();
	//System.out.println("inside method");
	//System.out.println(pvo.getProductName());
	String s="select Game_id from game_registration";
	rs1=st.executeQuery(s);
	String sp[]=new String[20];
	int i=0;
	while(rs1.next())
	{
	System.out.println(sp[i]);
	sp[i++]=rs1.getString("Game_id");
}
	return sp[i-1];
	}
	public boolean updatingElements(regBean vo) throws ClassNotFoundException, SQLException
	
	{
		System.out.println(vo.getGame_base_price());
		System.out.println("indao");
		//Statement st;
		boolean flag1=false;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cgc","root","root");
		st= con.createStatement();
		System.out.println(vo.getValidyear());
		int k=st.executeUpdate("update game_registration  set game_title='"+vo.getGametitle()+"',company='"+vo.getCompany()+
          "',game_releasedate='"+vo.getGamerelease()+"',game_type='"+vo.getGametype()+"',base_price='"+vo.getGame_base_price()+"',ins_date='"+vo.getInsdate()+"',valid_year='"+vo.getValidyear()+"',game_rating='"+vo.getGamerating()+"',Exp_date='"+vo.getExp_date()+"',price='"+vo.getPrice()+"' where game_id='"+vo.getGamerelease()+"'");
		System.out.println(k);
		if(k!=0){
			flag1=true;
			
		}
		return flag1;
	}
}


