package com.catp.cgc.bo;

import com.catp.cgc.businessexception.*;
import com.catp.cgc.vo.*;
public class searchbo {
public boolean validate(searchto boto) throws searchbusinessexception
{
	if(boto.getGame_title().isEmpty() && boto.getGame_type().equals("Default")&& boto.getCompany().equals("Default"))
		
		
	{
System.out.println("nt working");
		throw new searchbusinessexception("enter the details!");
	}
	else	
	return true;
}
}
