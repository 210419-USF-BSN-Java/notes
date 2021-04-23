package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {

	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		System.out.println("This is a sysout");
		log.trace("Trace");
		log.debug("Debug");
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		log.fatal("Fatal");
	}
}
