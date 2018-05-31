package com.catp.cgc.bo;

import java.util.List;

import com.catp.cgc.businessexception.*;
import com.catp.cgc.controller.*;
import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;


public class displaygamesbo {
	
	displaygamesdao dao3=new displaygamesdao();
	
	public List<displaygamesto> getdetails(searchto to){
		return  dao3.getdetails(to);
	}
	public boolean checkTime(playto to) throws searchbusinessexception 
	{
		String num="^[0-9]{1,}$";
		if(!to.getTime().matches(num))
		{
			System.out.println("asdghs");
			throw new searchbusinessexception("invalid hours");
		}else
		{
			return true;
		}
	}
}
