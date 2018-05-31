package com.catp.cgc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.catp.cgc.constants.QueryConstants;
import com.catp.cgc.exception.ApplicationException;
import com.catp.cgc.exception.DatabaseOperationException;
import com.catp.cgc.util.DbUtil;
import com.catp.cgc.vo.SellGameVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SellGameDAO.
 *
 * 
 */
public class SellGameDAO {
	
	/** The game details1. */
	public transient List<SellGameVO> gameDetails1; 
	
	/** The sell game vo. */
	public SellGameVO sellGameVo;
	
	/** The connection. */
	public transient Connection connection;
	
	/** The prepare statement. */
	public transient PreparedStatement prepareStatement;
	
	/** The prepare statement1. */
	public transient PreparedStatement prepareStatement1;
	
	/** The date value. */
	public transient Date dateValue=new Date();
	
	/** The locale. */
	public transient Locale locale=Locale.getDefault();
	
	/** The dateformat. */
	public transient SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd",locale);
	
	/** The current date. */
	public transient String currentDate=dateformat.format(dateValue);
	
	/** The result. */
	public transient ResultSet result=null;
	
	/** The result1. */
	public transient ResultSet result1=null;
	
	/** The result2. */
	public transient ResultSet result2=null;
	
	/** The discount. */
	public transient int discount;

/** Constructor invoked. */
	public static final Logger LOG = Logger.getLogger("SellGameDAO");
	public static int checkValue=0;
	/**
	 * Instantiates a new sell game dao.
	 */
	public SellGameDAO()
	{
		gameDetails1=new ArrayList<SellGameVO>();	
	}  
	
	/**
	 * Gets the player details.
	 *
	 * @param sellGameVo the sell game vo
	 * @return the player details
	 * @throws ClassNotFoundException the class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the sQL exception
	 */
	String id=null;
	String pass=null;
	public SellGameVO getPlayerDetails(final SellGameVO sellGameVo) throws ClassNotFoundException, IOException, SQLException
	{
		LOG.info("inside-method getPlayerDetails in SellGameDAO class");
		connection=DbUtil.getConnection();
		System.out.println("sads");
		prepareStatement=connection.prepareStatement(QueryConstants.SELECT_PLAYER);
		System.out.println(sellGameVo.getPlayerId());
		prepareStatement.setString(1, sellGameVo.getPlayerId());
		prepareStatement.setString(2, sellGameVo.getPlayerPassword());
		result=prepareStatement.executeQuery();
		checkValue=0;
		while(result.next())
			{
			id=(result.getString(1) );
			pass=(result.getString(2));
			sellGameVo.setAgeGroup(result.getString(3));
			sellGameVo.setDuration(result.getInt(4));
			sellGameVo.setFlag(true);
			}
		return sellGameVo;
	}
	
	/**
	 * Gets the all game details.
	 *
	 * @param sellGameVo1 the sell game vo1
	 * @return the all game details
	 * @throws ApplicationException the application exception
	 * @throws DatabaseOperationException the database operation exception
	 */
	public List<SellGameVO> getAllGameDetails(final SellGameVO sellGameVo1) throws ApplicationException,DatabaseOperationException
	{
		try{
			LOG.info("inside-method getAllGameDetails in SellGameDAO class");
			connection=DbUtil.getConnection();
			SellGameVO sellGameVo=sellGameVo1;
			sellGameVo=getPlayerDetails(sellGameVo);
			if(sellGameVo.getPlayerId().equals(id)&&sellGameVo.getPlayerPassword().equals(pass))
				{
				checkValue=3;
				final String ageGroups=sellGameVo.getAgeGroup();
				final int duration=sellGameVo.getDuration();
				prepareStatement1=connection.prepareStatement(QueryConstants.SELECT_DISCOUNT);
			
				prepareStatement1.setString(1,ageGroups);
				prepareStatement1.setInt(2,duration);
				result1=prepareStatement1.executeQuery();
				while(result1.next())
				{
				sellGameVo.setDiscount(result1.getInt(1));
				discount=sellGameVo.getDiscount();
				}
				gameDetails1=getGameDetails(sellGameVo);
				}
			}
			catch(SQLException e)
			{
			throw new DatabaseOperationException(e);
			}
			catch(ClassNotFoundException e)
			{
			throw new ApplicationException(e);
			}
			catch(IOException e)
			{
			throw new ApplicationException(e);
			}
		return gameDetails1;
	}
	
	/**
	 * Gets the game details.
	 *
	 * @param sellGameVo1 the sell game vo1
	 * @return the game details
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws IOException 
	 */
	public List<SellGameVO> getGameDetails(final SellGameVO sellGameVo1) throws DatabaseOperationException, ApplicationException, IOException
	{
		SellGameVO sellGameVo=sellGameVo1;
		gameDetails1=new ArrayList<SellGameVO>();
		LOG.info("inside-method getGameDetails in SellGameDAO class");
		try
		{
		LOG.info("inside-method getGameDetails in SellGameDAO class");
		connection=DbUtil.getConnection();
		prepareStatement1=connection.prepareStatement(QueryConstants.SELECT_GAME);
		//prepareStatement1.setString(1, currentDate.);
		result2=prepareStatement1.executeQuery();
		while(result2.next())
			{
				sellGameVo=new SellGameVO();
				sellGameVo.setDiscount(discount);
		 		sellGameVo.setGameTitle(result2.getString(1));
				sellGameVo.setGameType(result2.getString(2));
				final Integer price=result2.getInt(3);
				final String priceGame=price.toString();
				sellGameVo.setPrice(priceGame);
				final Integer rating=result2.getInt(4);
				final String ratingGame=rating.toString();
				sellGameVo.setRating(ratingGame);
				gameDetails1.add(sellGameVo);
				
			}
		}
		catch(ClassNotFoundException e)
		{
			throw new ApplicationException(e);
		}
		catch(IOException e)
		{
			throw new ApplicationException(e);
		}
		catch(SQLException sqlexception)
		{
			throw new DatabaseOperationException(sqlexception);
		}
		finally
		{
			try
			{
				prepareStatement.close();
				prepareStatement1.close();
				if(result!=null)
				{
				result.close();	
				}
				if(result1!=null)
				{
					result1.close();
				}
				if(result2!=null)
				{
					result2.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch(SQLException sqlexception)
			{
				LOG.info("SellGameDAO class Exception "+sqlexception.getMessage()); 
				new DatabaseOperationException(sqlexception);
			}
			catch(Exception exception)
			{
				LOG.info("SellGameDAO class Exception "+exception.getMessage()); 
				new DatabaseOperationException(exception);
			}
		}
		LOG.info("exit-method getGameDetails in SellGameDAO class");
		return gameDetails1;
	}
	
}
