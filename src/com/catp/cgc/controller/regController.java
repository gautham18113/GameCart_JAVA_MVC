package com.catp.cgc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.businessexception.*;
import com.catp.cgc.bo.*;
import com.catp.cgc.vo.*;

public class regController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("regController");
	public regController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOG.info("inside doPost method of regController");
	try{
		regBean vo = new regBean();
		vo.setGametitle(request.getParameter("gametitle"));
		vo.setCompany(request.getParameter("company"));
		vo.setGamerelease(request.getParameter("gamerelease"));
		vo.setGametype(request.getParameter("gametype"));
		vo.setGame_base_price(Integer.parseInt(request.getParameter("price")));
		vo.setInsdate(request.getParameter("insdate"));
		vo.setGamerating(Integer.parseInt(request.getParameter("gamerating")));
		try{
			vo.setValidyear(Integer.parseInt(request.getParameter("validyear")));
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			LOG.error("regController number format exception"+e.getMessage());
			throw new BusinessException("Validity Should be Number");
		}
		
		
			boolean b1 = false;
			b1=new regBO().validate(vo);
			//System.out.println("after dao"+b1);
			if(b1==true)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("success.jsp");
				rd1.forward(request, response);
			}
		}
		catch (BusinessException e) {
			LOG.error("regController business exception"+e.getMessage());
			RequestDispatcher rd2=request.getRequestDispatcher("game_registration.jsp");
			request.setAttribute("message", e.getMessage());
			rd2.forward(request, response);
		}
			

	
		

	}

}
