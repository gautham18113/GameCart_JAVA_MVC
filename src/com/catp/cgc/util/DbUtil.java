package com.catp.cgc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class DbUtil.
 */
public class DbUtil {

    /** The connection. */
    private static Connection connection = null;

    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws ClassNotFoundException the class not found exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException the SQL exception
     */
    public static Connection getConnection()throws  ClassNotFoundException, IOException, SQLException {
        
                final Properties prop = new Properties();
                final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                final String driver = prop.getProperty("driver");
                final String url = prop.getProperty("url");
                final String user = prop.getProperty("user");
                final String password = prop.getProperty("password");
                Class.forName(driver);
    	    	//Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
