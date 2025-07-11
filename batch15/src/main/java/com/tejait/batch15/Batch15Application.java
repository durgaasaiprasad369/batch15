package com.tejait.batch15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Batch15Application {
    private static final Logger logger = LogManager.getLogger(Batch15Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Batch15Application.class, args);
		System.out.println("hello Prasad BATCH15...");
		 logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Hey, This is a warning!");
	        logger.error("Oops! We have an Error. OK");
	        logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
