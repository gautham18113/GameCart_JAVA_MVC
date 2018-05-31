package com.catp.cgc.bo;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.catp.cgc.businessexception.*;

import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;



public class regBO {
	
	public boolean validate(regBean bo) throws BusinessException {
		boolean flag=false;
		String test="(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)";
		Date cd=new Date();

		if(!bo.getGamerelease().matches(test)){
			throw new BusinessException("Game Release date is invalid Format it should be in dd-MM-yyyy format");
		}
		else{
			SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			Date d1;
			try {
				d1 = df.parse(bo.getGamerelease());
				if(d1.compareTo(cd)>0)
				{
					throw new BusinessException("Game Release Date Must be Lessthan Current Date");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!bo.getInsdate().matches(test))
		{
			throw new BusinessException("Installation Date is Invalid Format it should be in dd-MM-yyyy format");
		}
		else{
			SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			Date d2;
			try {
				d2=df.parse(bo.getInsdate());
				if(d2.compareTo(cd)>0)
				{
					throw new BusinessException("Installation Date must be Lessthan Current Date");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bo.getValidyear()>5)
		{
			bo.setPrice(bo.getGame_base_price()* bo.getValidyear());
		}
		else{
			throw new BusinessException("Validity Must be Greater Than 5");
		}
		String exp_date="";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date ex_date=sdf.parse(bo.getInsdate());
			ex_date.setYear(ex_date.getYear()+bo.getValidyear());
			ex_date.setDate(ex_date.getDate()-1);
			sdf=new SimpleDateFormat("dd-MM-yyyy");
			exp_date=sdf.format(ex_date);
			bo.setExp_date(exp_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		regDao dao=new regDao();
		flag=new regDao().connection(bo);
		return flag;	
	}
	public String getDistributorid() throws ClassNotFoundException, SQLException
	{
	String s="";
	//System.out.println("****");
	regDao pdao1=new regDao();
	s=pdao1.getDistributoriddao();
	return s;
	}
	public boolean updatingelements(regBean vo) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		System.out.println(vo.getExp_date());
		
		System.out.println("inbo");
		regDao dd=new regDao();
		flag=dd.updatingElements(vo);
		return flag;

}
}
