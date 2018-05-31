package com.catp.cgc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catp.cgc.bo.*;
import com.catp.cgc.logger.LoggerInitialiser;
import com.catp.cgc.vo.*;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("LoginController");
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("inside doPost method of LoginController");
		loginBean vo = new loginBean();
		vo.setAdminid(request.getParameter("Adminid"));
		vo.setPassword(request.getParameter("password"));
		loginBO bo = new loginBO();
		try {
			if (bo.validate(vo)) {

				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("game_registration.jsp");
				dispatcher.forward(request, response);
			} else {
			      request.setAttribute("message","enter the details");	
			
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("login.jsp");
				System.out.println("Enter the details");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
