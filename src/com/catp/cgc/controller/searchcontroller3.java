package com.catp.cgc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.displaygamesbo;
import com.catp.cgc.bo.searchbo;
import com.catp.cgc.businessexception.searchbusinessexception;
import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;

/**
 * Servlet implementation class searchcontroller3
 */
public class searchcontroller3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("searchcontroller3");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchcontroller3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside doGet method of searchcontroller3");
		System.out.println("searchcontroller");
		searchdao dao=new searchdao();
		searchto to=new searchto();
		System.out.println("enter");
		List<searchto> l=dao.validate(to);
		System.out.println("validating");
		request.setAttribute("message",l);
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside doPost method of searchcontroller3");
		displaygamesbo bo=new displaygamesbo();
		
		displaygamesdao dao=new displaygamesdao();
		searchbo bo1=new searchbo();
		searchto sto=new searchto();
		if(request.getParameter("search").equals("search"))
		{
	
		sto.setGame_title(request.getParameter("game_title"));
		sto.setGame_type(request.getParameter("game_type"));
		sto.setCompany(request.getParameter("company"));
		try {
			if(bo1.validate(sto))
			{
				List<displaygamesto> l4=bo.getdetails(sto);
				request.setAttribute("message",l4);
			RequestDispatcher rd=request.getRequestDispatcher("displaygames.jsp");
			rd.forward(request,response);	
}
			
		} catch (searchbusinessexception e) {
			
			// TODO Auto-generated catch block
			LOG.error("searchcontroller3 search business exception"+e.getMessage());
			searchdao dao1=new searchdao();
			searchto to1=new searchto();
			List<searchto> l=dao1.validate(to1);
			request.setAttribute("message",l);
			request.setAttribute("message1",e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request,response);
			
		}
		}
				
		playto pto=new playto();
		pto.setId(request.getParameter("id"));
		pto.setPwd(request.getParameter("pwd"));
		pto.setTime(request.getParameter("time"));
		try {
			if(dao.checkuser(pto))
			{
				
			
				
			
				if(dao.checktime(pto))
				{
					dao.updatetime(pto);
					System.out.println("hiii");
					RequestDispatcher rd=request.getRequestDispatcher("play.jsp");
					rd.forward(request,response);
				}
			
				
}
		} catch (searchbusinessexception e) {
			// TODO Auto-generated catch block
			LOG.error("searchcontroller3 search business exception"+e.getMessage());
			/*request.setAttribute("message4",e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("displaygames.jsp");
			rd.forward(request,response);*/
		}
}
	}


