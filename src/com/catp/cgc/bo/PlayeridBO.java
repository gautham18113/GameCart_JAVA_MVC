package com.catp.cgc.bo;

import com.catp.cgc.dao.*;
import com.catp.cgc.exception.*;
import com.catp.cgc.vo.*;

public class PlayeridBO {
public boolean validation(Player_idTO pto) throws PlayeridException, ClassNotFoundException
    {
	boolean b=false;
	int f=0;
	String pnam=pto.getPlayername();
	String mail=pto.getPlayermail();
	String num=pto.getPlayercontact();
	String pswrd=pto.getPassword();
	String age=pto.getPlayerage();
	String agegr=pto.getAgegroup();
	String dur=pto.getDuration();
	int ag=Integer.parseInt(age);
	int dr=Integer.parseInt(dur);
	for(int i=0;i<pnam.length();i++)
	{
		if(!Character.isLetter(pnam.charAt(i)))
			f=1;
	}
	if(f==1)
	{
			throw new PlayeridException("name should only contain alphabets");
		
	}
	for(int i=0;i<age.length();i++)
	{
		if(!Character.isDigit(age.charAt(i)))
		
			f=2;
	}
		
		if(f==2)
		{
			throw new PlayeridException("please enter age in digits ");
		}
	
	if(f==0)
	{
	if(ag<13)
	{
		if(!agegr.equalsIgnoreCase("kids"))
		{
			throw new PlayeridException("please enter appropriate age group");
		}
	}
	else if(ag>=13 && ag<=19)
	{
		if(!agegr.equalsIgnoreCase("teenagers"))
		{
			throw new PlayeridException("please enter appropiate age group");
		}
	}
	else if(ag>19)
	{
		if(!agegr.equalsIgnoreCase("grownups"))
			throw new PlayeridException("please enter appropiate age group");
	}
	}
	String reg1="^[a-zA-Z0-9]{1,}[@][a-zA-Z]{1,}[.][c][o][m]$";
	if(!(mail.matches(reg1)))
	{
		f=3;
		throw new PlayeridException("email is not valid");
		
	}
	if(num.length()==10)
	{
	for(int i=0;i<num.length();i++)
	{
		if(!Character.isDigit(num.charAt(i)))
		{
			f=4;
			throw new PlayeridException("phone number is not valid");
		}
	}
	}
	else
	{
		f=4;
		throw new PlayeridException("phone number is not valid");
	}
	if(pswrd.length()>=4 && pswrd.length()<=8)
	{
		if(!pswrd.contains("#"))
		{
			f=5;
			throw new PlayeridException("password should be 3 to 8 word " +
					"length and must contain #");
		}
	}
	else
	{
		f=5;
		throw new PlayeridException("password should be 3 to 8 word " +
		"length and must contain #");
	}
	if(agegr.equalsIgnoreCase("kids")) 
	{
		if(dr==100)
		{
			dr=dr+5;
		}
		if(dr==200)
		{
			dr=dr+14;
		}
		if(dr==300)
		{
			dr=dr+30;
		}
		if(dr==400)
		{
			dr=dr+48;
		}
		pto.setDuration(Integer.toString(dr));
	}
	if(agegr.equalsIgnoreCase("teenagers")) 
	{
		if(dr==100)
		{
			dr=dr+2;
		}
		if(dr==200)
		{
			dr=dr+10;
		}
		if(dr==300)
		{
			System.out.println("enter");
			dr=dr+15;
		}
		if(dr==400)
		{
			dr=dr+32;
		}
		pto.setDuration(Integer.toString(dr));
	}
	if(agegr.equalsIgnoreCase("grownups")) 
	{
		if(dr==100)
		{
			dr=dr+0;
		}
		if(dr==200)
		{
			dr=dr+0;
		}
		if(dr==300)
		{
			dr=dr+0;
		}
		if(dr==400)
		{
			dr=dr+20;
		}
		pto.setDuration(Integer.toString(dr));
	}
	if(f==0)
	{
		PlayeridDAO pdao=new PlayeridDAO();
		b=pdao.insertValues(pto);
	}
	return b;
	}
}
