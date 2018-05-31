package com.catp.cgc.bo;


import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

import com.catp.cgc.dao.SellGameDAO;
import com.catp.cgc.constants.ErrorConstants;
import com.catp.cgc.exception.ApplicationException;
import com.catp.cgc.exception.BusinessException;
import com.catp.cgc.exception.DatabaseOperationException;
import com.catp.cgc.util.PropertyUtil;
import com.catp.cgc.vo.SellGameVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SellGameBO.
 *
 * 
 */
public class SellGameBO {

	/** The sell game dao. */
	public transient SellGameDAO sellGameDao;
	
	/** The game details. */
	public transient List<SellGameVO> gameDetails;
	
	/** The message. */
	public transient String message="";
	
	/** The value. */
	public int value=0;
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("SellGameBO");
	
	/**
	 * Instantiates a new sell game bo.
	 */
	public SellGameBO()
	{
	sellGameDao=new com.catp.cgc.dao.SellGameDAO();	
	}
	
/**
 * Validate player.
 *
 * @param sellGameVo1 the sell game vo1
 * @return the list
 * @throws BusinessException the business exception
 * @throws DatabaseOperationException the database operation exception
 * @throws ApplicationException the application exception
 */
public List<SellGameVO> validatePlayer(final SellGameVO sellGameVo1) throws BusinessException,DatabaseOperationException,ApplicationException 
{
	LOG.info("inside-method validatePlayer in SellGameBO class");
	SellGameVO sellGameVo=sellGameVo1;
	final String playrid=sellGameVo.getPlayerId();
	final String playrpwd=sellGameVo.getPlayerPassword();
	System.out.println("asdasd");
	gameDetails=sellGameDao.getAllGameDetails(sellGameVo);
	System.out.println("asdasd");
	final char[] charArrayForId=playrid.toCharArray();
	sellGameVo.setVal(0);
	final int length=charArrayForId.length;
	final int idlen=playrid.length();
	final int passwordlength=playrpwd.length();
	validateField(sellGameVo1);
		if(idlen>0)
		{
			for(int count=0;count<length;count++)
			{
				if(!Character.isLetterOrDigit(charArrayForId[count]))
				{
					sellGameVo.setVal(1);
					message=PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPLAYERID);
					LOG.debug(message);
					throw new BusinessException(message);
				}
				
			}
			if(passwordlength>0)
				{
					gameDetails=sellGameDao.getAllGameDetails(sellGameVo);
					final Iterator<SellGameVO> iterate=gameDetails.iterator();
				while(iterate.hasNext())
				{
					sellGameVo=iterate.next();
				}
				if(SellGameDAO.checkValue!=3)
				{
					message=PropertyUtil.getErrorMessage(ErrorConstants.IDPASSWORDINVALID);
			 		LOG.debug(message);
					throw new BusinessException(message);
				}
				
				}
			else
			{
				message=PropertyUtil.getErrorMessage(ErrorConstants.PASSWORDEMPTY);
				LOG.debug(message);
				throw new BusinessException(message);
			}
		}
		LOG.info("exit-method validatePlayer in SellGameBO class");
		return gameDetails;
}

/**
 * Validate field.
 *
 * @param sellGameVo1 the sell game vo1
 * @throws BusinessException the business exception
 */
public void validateField(final SellGameVO sellGameVo1) throws BusinessException
{
	LOG.info("inside-method validateField in SellGameBO class");
	final SellGameVO sellGameVo=sellGameVo1;
	final String playrid=sellGameVo.getPlayerId();
	final String playrpwd=sellGameVo.getPlayerPassword();
	final int idlen=playrid.length();
	final int passwordlength=playrpwd.length();
	
		 if(idlen==0&&passwordlength>0)
		{
			message=PropertyUtil.getErrorMessage(ErrorConstants.PLAYERIDEMPTY);
			LOG.debug(message);
			throw new BusinessException(message);
		}
		else if(idlen==0&&passwordlength==0)
		{
			message=PropertyUtil.getErrorMessage(ErrorConstants.BOTHIDPSWDEMPTY);
			LOG.debug(message);
			throw new BusinessException(message);
		}
	LOG.info("exit-method validatePlayer in SellGameBO class");
		
	
	

	
}
}
