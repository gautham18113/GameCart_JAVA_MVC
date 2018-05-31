package com.catp.cgc.util;

import java.util.Locale;
import java.util.ResourceBundle;

import com.catp.cgc.constants.ErrorConstants;
import com.catp.cgc.constants.SuccessConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyUtil.
 */
public final class PropertyUtil {
 
	
	/**
	 * Instantiates a new property util.
	 */
	private PropertyUtil()
 {
 new PropertyUtil();
 }
 
 /**
  * Gets the bundles.
  *
  * @param filename the filename
  * @return the bundles
  */
 private static ResourceBundle getBundles(final String filename)
 {
	 final Locale currentLocale=Locale.getDefault();
	 return ResourceBundle.getBundle(filename,currentLocale);
 }
 
 /**
  * Gets the error message.
  *
  * @param key the key
  * @return the error message
  */
 public static String getErrorMessage(final String key)
 {
	 final ResourceBundle message=getBundles(ErrorConstants.ERRORMESSAGES);
	 return message.getString(key);
 }
	
 /**
  * Gets the success message.
  *
  * @param key the key
  * @return the success message
  */
 public static String getSuccessMessage(final String key)
 {
	 final ResourceBundle message=getBundles(SuccessConstants.SUCCESSMESSAGES);
	 return message.getString(key);
 }
}
