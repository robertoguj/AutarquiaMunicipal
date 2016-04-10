package amc.scda.test;

import org.apache.log4j.Logger;

public class Log4jTeste {
	
	static Logger logger = Logger.getLogger(Log4jTeste.class);
	
	public static void main (String[] agrs) {
		logger.debug("DEBUG MSG");
		logger.info("INFO MSG");
		logger.warn("WARN MSG");
		logger.error("ERROR MSG");
		logger.fatal("FATAL MSG");
	}

}
