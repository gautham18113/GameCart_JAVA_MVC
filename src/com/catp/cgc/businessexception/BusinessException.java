package com.catp.cgc.businessexception;

public class BusinessException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	public BusinessException(String message)
	{
		super(message);
	}
	public BusinessException(Throwable throwable)
	{
		super(throwable);
	}

}
