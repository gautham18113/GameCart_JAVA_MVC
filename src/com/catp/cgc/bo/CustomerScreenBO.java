package com.catp.cgc.bo;

import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;

public class CustomerScreenBO {
	public String customerScreen(CustomerScreenBean csb)
	{
	CustomerScreenDAO csdao=new CustomerScreenDAO();
	String sid="";
	if((csb.getPlayerID()!="")&&(csb.getPlayerID().matches("^[A-Za-z0-9]*$")))
	{
		if((csb.getPassword()!="")&&(csb.getPassword().length()>=4)&&(csb.getPassword().length()<=8)&&(csb.getPassword().matches("^[A-Za-z0-9]*[#]+[A-Za-z0-9]*$")))
		{
			if(csb.getRequest()!="")
			{
				sid=csdao.customerScreen(csb);
			}
			else
			{
				System.out.println("Feedback Empty");
			}
		}
		else
		{
			System.out.println("Password Wrong");
		}
	}
	else
	{
		System.out.println("PlayerID Wrong");
	}
	return sid;
	}

}
