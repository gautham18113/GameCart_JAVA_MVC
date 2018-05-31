package com.catp.cgc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.*;
import com.catp.cgc.vo.*;



/**
 * Servlet implementation class CustomerscreenController
 */
public class CustomerscreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("CustomerscreenController");
    public CustomerscreenController() {
        super();
    }
        // TODO Auto-generated constructor stub
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside doPost method of CustomerscreenController");
		CustomerScreenBean csb=new CustomerScreenBean();
		csb.setPlayerID(request.getParameter("id"));
		csb.setPassword(request.getParameter("passwd"));
		csb.setRequest(request.getParameter("feedbackrequest"));
		System.out.println(csb.getRequest());
		
		CustomerScreenBO csbo=new CustomerScreenBO();
		
		
			String sid=csbo.customerScreen(csb);
			if(!sid.isEmpty())
			{
				System.out.println("1");
				HttpSession hs=request.getSession();
				hs.setAttribute("suggest",sid);
				if(!csb.getRequest().equals("Game Request"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("FeedBack2.jsp");
			
					hs.setAttribute("feedback",csb.getPlayerID());
					hs.setAttribute("game",csb.getRequest());
			
				rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("Feedback.jsp");
					
					hs.setAttribute("feedback",csb.getPlayerID());
					hs.setAttribute("game",csb.getRequest());
					
					rd.forward(request, response);
				}
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("error1.jsp");
				
				rd.forward(request, response);	
			}
	}

}
