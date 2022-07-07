package utils;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.log4testng.Logger;

public class LoggerConfig {
	  static Logger logger = Logger.getLogger(LoggerConfig.class);
	  
	    public static void main(String[] args)
	    {
	        //DOMConfigurator is used to configure logger from xml configuration file
	        DOMConfigurator.configure("log4j.xml");
	 
	        //Log in console in and log file
	        logger.debug("Log4j appender configuration is successful !!");
	        
	    }
	}
