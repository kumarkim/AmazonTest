package log;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factory.DriverFactory;

public class AmazonLogger {
	
	Logger log;

	private AmazonLogger() {
		log = LogManager.getLogger("AMAZON");
	}

	private static class ObjectHOLDER {
		private static final AmazonLogger logger = new AmazonLogger();
	}

	public static AmazonLogger getInstance() {
		return ObjectHOLDER.logger;
	}

	public void logInfo(String className, String level , String message) {
		log.info(message);
	}
	public void logDebug(String className, String level , String message) {
		
	}
	public void logError(String className, String level , String message, String Exception ) {
	
}
}
