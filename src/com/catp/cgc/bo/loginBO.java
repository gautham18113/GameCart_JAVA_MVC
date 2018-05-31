package com.catp.cgc.bo;

import java.sql.SQLException;

import com.catp.cgc.dao.LoginDAO;
import com.catp.cgc.vo.*;

//import com.login.loginbean.loginBean;

public class loginBO {
	boolean flag = false;

	public boolean validate(loginBean b) throws ClassNotFoundException, SQLException {
		if(LoginDAO.connect(b))
		{
			flag=true;
		}
		
		/*if ((b.getAdminid().matches("Admin"))
				&& (b.getPassword().matches("Admin"))) 
		{

			flag = true;
		}*/
System.out.println("in bo");
		return flag;

	}

}
