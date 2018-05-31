package com.catp.cgc.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseOperationException.
 */
public class DatabaseOperationException extends SystemException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new database operation exception.
	 *
	 * @param errCode the err code
	 * @param cause the cause
	 */
	public DatabaseOperationException(final String errCode,final Throwable cause) {
		super(errCode, cause);
	}

	/**
	 * Instantiates a new database operation exception.
	 *
	 * @param errCode the err code
	 */
	public DatabaseOperationException(final String errCode) {
		super(errCode);
	}

	/**
	 * Instantiates a new database operation exception.
	 *
	 * @param throwable the throwable
	 */
	public DatabaseOperationException(final Throwable throwable) {
		super(throwable);
	}

}
