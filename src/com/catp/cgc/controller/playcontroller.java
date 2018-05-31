package com.catp.cgc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.*;
import com.catp.cgc.businessexception.*;
import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;


/**
 * Servlet implementation class playcontroller
 */
public class playcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("playcontroller");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside doPost method of playcontroller");
		displaygamesbo bo=new displaygamesbo();
		searchto sto=new searchto();
		displaygamesdao dao=new displaygamesdao();
		playto pto=new playto();
		pto.setId(request.getParameter("id"));
		pto.setPwd(request.getParameter("pwd"));
		pto.setTime(request.getParameter("time"));
		try {
			System.out.println("no user");
			System.out.println(dao.checkuser(pto));
			if(dao.checkuser(pto)==true)
			{
				System.out.println("user done");
				if(bo.checkTime(pto))
				{
					dao.checktime(pto);
					dao.updatetime(pto);
					System.out.println("hiii");
					RequestDispatcher rd=request.getRequestDispatcher("play.jsp");
					rd.forward(request,response);
				}			
}
		} catch (searchbusinessexception e) {
			
			// TODO Auto-generated catch block
			LOG.error("playcontroller search business exception"+e.getMessage());
		
		
			RequestDispatcher rd=request.getRequestDispatcher("displaygames.jsp");
			request.setAttribute("message4",e.getMessage());
			
			
			rd.forward(request,response);
		}
}
	}


