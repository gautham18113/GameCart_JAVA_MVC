package com.catp.cgc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.SellGameBO;
import com.catp.cgc.constants.ErrorConstants;
import com.catp.cgc.constants.SuccessConstants;
import com.catp.cgc.dao.SellGameDAO;
import com.catp.cgc.exception.ApplicationException;
import com.catp.cgc.exception.BusinessException;
import com.catp.cgc.exception.DatabaseOperationException;
import com.catp.cgc.util.PropertyUtil;
import com.catp.cgc.vo.SellGameVO;
	// TODO: Auto-generated Javadoc
/*
	 * Servlet implementation class SellGameServlet This Servlet acts as the controller
	 * for the SellGame process.This is called when the user submits the SellGameLogin.jsp
	 * page.
	 */

	/**
	 * The Class SellGameController.
	 */
	public class SellGameController extends HttpServlet {
	
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The sell game bo. */
		public transient SellGameBO sellGameBo;
		
		/** The sell game vo. */
		public transient SellGameVO sellGameVo;
		
		/** The sell game dao. */
		public transient SellGameDAO sellGameDao;
		
		/** The game details. */
		public transient List<SellGameVO> gameDetails;
		
		/** The requestdispatch. */
		public transient RequestDispatcher requestdispatch;
		
		/** The message. */
		public transient String message="";
		
		/** The Constant LOG. */
		public static final Logger LOG = Logger.getLogger("SellGameController");
		
	 /* The Logger for logging the errors and info
	*Logger object used for logging the errors and info
	*/
	/**
 	 * Instantiates a new sell game controller.
 	 */
 	public SellGameController() 
	{
    	super();
		sellGameBo=new SellGameBO();
    	sellGameVo=new SellGameVO();
    	sellGameDao=new SellGameDAO();
    	
    }
	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException 
	{
		final String actionValue=request.getParameter("action");
		
		final String playerId=request.getParameter("playerid");
		final String playerPassword=request.getParameter("playerpswd");
		sellGameVo.setPlayerId(playerId);
		sellGameVo.setPlayerPassword(playerPassword);
		LOG.info("SellGameServlet invoked Player Id: "+playerId+" Password: "+playerPassword);
		LOG.info("inside-method doPost in SellGameController class");
		try
		{
			if(actionValue.equals("registereduser"))
			{
				gameDetails=sellGameBo.validatePlayer(sellGameVo);
				request.setAttribute("gamedetails",gameDetails);
				request.setAttribute("option","buy");
				requestdispatch=request.getRequestDispatcher(SuccessConstants.GAMEDETAILSCREEN);
				requestdispatch.forward(request, response);
			}
			else if(actionValue.equals("guestuser"))
			{
				gameDetails=sellGameDao.getGameDetails(sellGameVo);
				request.setAttribute("gamedetails",gameDetails);
				request.setAttribute("option","---");
				requestdispatch=request.getRequestDispatcher(SuccessConstants.GAMEDETAILSCREEN);
				requestdispatch.forward(request, response);
			}
			else if(actionValue.equals("buy"))
			{
				String gg=(String) request.getParameter("price");
				System.out.println(gg);
				requestdispatch=request.getRequestDispatcher(SuccessConstants.GAMEDETAILSCREEN);
				requestdispatch.forward(request, response);
				
			}
			
			LOG.info("exit-method validatePlayer in SellGameController class");
		}
		catch(BusinessException businessexception)
		{
			LOG.info("SellGameController class Exception "+businessexception.getMessage());
			request.setAttribute("playerId", playerId);
			request.setAttribute("message", businessexception.getMessage());
			requestdispatch=request.getRequestDispatcher(SuccessConstants.LOGINSCREEN);
			requestdispatch.forward(request, response);
		}
		catch (ApplicationException appexception) 
		{
			LOG.info("SellGameController class Exception "+appexception.getMessage());
			message=PropertyUtil.getErrorMessage(ErrorConstants.APPLICATIONERROR);
			request.setAttribute("message", message);
			requestdispatch=request.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			requestdispatch.forward(request, response);
		} 
		catch (DatabaseOperationException databaseexception)
		{
			LOG.info("SellGameController class Exception "+databaseexception.getMessage());
			message=PropertyUtil.getErrorMessage(ErrorConstants.DATABASEERROR);
			request.setAttribute("message",message);
			requestdispatch=request.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			requestdispatch.forward(request, response);
		} 
		}
		
	}


