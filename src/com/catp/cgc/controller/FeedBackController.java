package com.catp.cgc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.catp.cgc.vo.*;
import com.catp.cgc.bo.*;

/**
 * Servlet implementation class FeedBackController
 */
public class FeedBackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("FeedBackController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackController() {
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
		LOG.info("inside doPost method of FeedBackController");
		boolean b=false;
		FeedBackBean fb = new FeedBackBean();
		HttpSession hs = request.getSession();
		fb.setPlayerid(hs.getAttribute("feedback").toString());
		fb.setSuggestion(hs.getAttribute("suggest").toString());
		fb.setFeedback(request.getParameter("text"));
		fb.setGame_title(request.getParameter("text1"));
		fb.setVendor(request.getParameter("text2"));
		fb.setDesc(request.getParameter("text3"));
		fb.setType(hs.getAttribute("game").toString());
		FeedBackBO fbo = new FeedBackBO();
		if(fb.getType().equalsIgnoreCase("Game Request"))
			b=fbo.feedBack(fb);
		else if(fb.getType().equalsIgnoreCase("General Feedback"))
			b=fbo.generalFeedback(fb);
		if(b==true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("feedbacksuccess.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("error1.jsp");
			rd.forward(request, response);
		}
		
	}

}
