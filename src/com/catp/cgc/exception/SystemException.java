//Package
package com.catp.cgc.exception;
// TODO: Auto-generated Javadoc
/**
 * This class used to handle SystemException.
 */
public class SystemException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * String object containing the exception error code.
	 */
	private transient String errorCode;

	/**
	 * Throwable cause containing the actual cause of the exception.
	 */
	private transient Throwable cause;

	/**
	 * Default Constructor for SystemException.
	 * 
	 * @param throwable
	 *            Throwable
	 */
	public SystemException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Constructs an SystemException with the specified error code.
	 * 
	 * @param errCode -
	 *            error code for the error description.
	 */
	public SystemException(final String errCode) {
		this.errorCode = errCode;
	}

	/**
	 * Constructor with two parameters.
	 * 
	 * @param errCode
	 *            String
	 * 
	 * @param cause
	 *            Throwable
	 */
	public SystemException(final String errCode, final Throwable cause) {
		super(errCode, cause);
		this.errorCode = errCode;
		this.cause = cause;
	}

	/**
	 * Gets the error code of the exception.
	 * 
	 * @return <b> String </b> error code of the exception.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the Exception cause.
	 * 
	 * @return Throwable the actual cause of exception
	 */
	public Throwable getExceptionCause() {
		return cause;
	}
}
