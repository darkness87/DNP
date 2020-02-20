package com.dnp.home.util;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class IdMaker {

	static Logger log = LogManager.getLogger(IdMaker.class);
	private static String serverID = "1";
	
	static{
//		IdMaker.serverID = PropertyConfig.properties.getProperty("serverid", "1");
	}

	public static String getUniqueID() {
		return getUniqueID(System.currentTimeMillis());
	}

	public static String getUniqueID(Date date) {
		return getUniqueID(date.getTime());
	}

	public static synchronized String getUniqueID(long date) {
		String keyID = Long.toString(date, 36);
		try {
			Thread.sleep(1);
		} catch(InterruptedException ine) {
			log.debug(ine.getMessage());
		}
		return serverID + keyID;
	}
}