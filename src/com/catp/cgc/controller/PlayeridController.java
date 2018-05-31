package com.catp.cgc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.*;
import com.catp.cgc.exception.*;
import com.catp.cgc.vo.*;
/**
 * Servlet implementation class PlayeridController
 */
public class PlayeridController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("PlayeridController");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayeridController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		LOG.info("inside doPost method of PlayeridController");
		try
		{
		Player_idTO pto=new Player_idTO();
		pto.setPlayername(request.getParameter("playername"));
		pto.setPlayerage(request.getParameter("playerage"));
		pto.setPlayermail(request.getParameter("playeremail"));
		pto.setPlayeraddress(request.getParameter("playeraddress"));
		pto.setPlayercontact(request.getParameter("playercontact"));
		pto.setDuration(request.getParameter("duration"));
		pto.setPassword(request.getParameter("password"));
		pto.setGender(request.getParameter("gender"));
		pto.setAgegroup(request.getParameter("agegroup"));
		if(pto.getPlayername().isEmpty())
		{
			throw new PlayeridException("Please enter name");
		}
		if(pto.getPlayerage().isEmpty())
		{
			throw new PlayeridException("Please enter age");
		}
		if(pto.getPlayermail().isEmpty())
		{
			throw new PlayeridException("Please enter email id");
		}
		if(pto.getPlayeraddress().isEmpty())
		{
			throw new PlayeridException("Please enter address");
		}
		if(pto.getPlayercontact().isEmpty())
		{
			throw new PlayeridException("Please enter phone number");
		}
		if(pto.getDuration()==null)
		{
			throw new PlayeridException("Please select duration");
		}
		if(pto.getPassword().isEmpty())
		{
			throw new PlayeridException("Please enter password");
		}
		if(pto.getGender()==null)
		{
			throw new PlayeridException("Please select gender");
		}
		if(pto.getAgegroup()==null)
		{
			throw new PlayeridException("Please select age group");
		}
		PlayeridBO pbo=new PlayeridBO();
		try {
			if(pbo.validation(pto))
			{
				RequestDispatcher rqdp=request.getRequestDispatcher("success.jsp");
				rqdp.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			LOG.error("Playerid Controller class not found exception"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(PlayeridException e)
		{
			LOG.error("PlayeridController Playerid exception"+e.getMessage());
			request.setAttribute("message",e.getMessage());

			RequestDispatcher dispatcher=request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		catch(NullPointerException e)
		{
			
		}
		
	}

}
