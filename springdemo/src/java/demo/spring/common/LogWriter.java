/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author akhalik
 */
public class LogWriter {
    
    private static final Log logger = LogFactory.getLog(LogWriter.class);
    private static final Log queryLogger = LogFactory.getLog("queryLogger");

	/**
	 * @param message
	 */
	public static void info(String message) {

		logger.info(message);
	}

	/**
	 * @param clssNm
	 * @param methodNm
	 * @param message
	 */
	public static void info(String className, String methodName, String message) {
		logger.info(message);
	}

	/**
	 * @param message
	 * @param t
	 */
	public static void error(String message, Throwable t) {
		logger.error(message, t);
	}

	/**
	 * @param message
	 */
	public static void debug(String message) {
		logger.debug(message);
	}

	/**
	 * This method logs query details.
	 * 
	 * @param category
	 *            Log category("*"=Error, "!"=Warn/Slow query, ""=Normal query)
	 * @param elapsed
	 * @param className
	 * @param methodName
	 * @param logMsg
	 */
	public static void logQuery(String category, long elapsed, String className, String methodName, String logMsg) {
		String msg = prepareLogMsg(category, elapsed, className, methodName, logMsg);

		if (category.equals(BaseConstants.NORMAL_CONTEXT)) {
			// Normal context i.e. print executed queries.
			queryLogger.debug(msg);
		} else if (category.equals(BaseConstants.SLOW_CONTEXT)) {
			// Slow query i.e. query took more time then defined threshold.
			queryLogger.warn(msg);
		} else if (category.equals(BaseConstants.ERROR_CONTEXT)) {
			// Errorous queries
			queryLogger.error(msg);
		}
	}

	/**
         * returns string joining the parameter passed
         * @param category
         * @param elapsed
         * @param className
         * @param methodName
         * @param logMsg
         * @return 
         */
	private static String prepareLogMsg(String category, long elapsed, String className, String methodName, String logMsg) {
            //TODO: saperator needs to be taken from property file
		return BaseCommon.join(new String[] { category, Long.toString(elapsed), className, methodName, logMsg }, "|");
	}
}

