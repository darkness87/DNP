package com.dnp.home.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertyMessage {
	final static Logger logger = LogManager.getLogger(PropertyMessage.class);

	static MessageSourceAccessor messageSourceAccessor;

	public PropertyMessage() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:com/dnp/home/viewmessages");
		PropertyMessage.messageSourceAccessor = new MessageSourceAccessor(messageSource);
	}

	public static void setMessageSourceAccsssor(MessageSourceAccessor messageSourceAccessor) {
		PropertyMessage.messageSourceAccessor = messageSourceAccessor;
	}

//	public ReloadableResourceBundleMessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:com/dnp/home/viewmessages");
//		System.out.println("message : " + new MessageSourceAccessor(messageSource).getMessage("dnp.product.name"));
//		return messageSource;
//	}
//
//	public MessageSourceAccessor messageSourceAccessor() {
//		return new MessageSourceAccessor(messageSource());
//	}

//	public static MessageSourceAccessor getMessageSourceAccessor() {
//		return msessageSourceAccessor;
//	}
	
//	public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
//		PropertyMessage.messageSourceAccessor = messageSourceAccessor;
//	}

	public static String getMessage(String key) {
		try {
			return messageSourceAccessor.getMessage(key);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return "";
		}
	}

	public static String getMessage(String key, String value) {
		try {
			return messageSourceAccessor.getMessage(key).replace("{0}", value);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return "";
		}
	}

	public static String getMessage(String key, String value1, String value2) {
		try {
			return messageSourceAccessor.getMessage(key).replace("{0}", value1).replace("{1}", value2);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return "";
		}
	}

	public static String getCodeMessage(int key) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key));
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String getCodeMessage(int key, String value) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key)).replace("{0}", value);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key));
		}
	}

	public static String getCodeMessage(int key, String name, String value) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key)).replace("{0}", name).replace("{1}", value);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + Integer.toString(key));
		}
	}

	public static String getCodeMessage(String key) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + key);
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static String getCodeMessage(String key, String value) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + key).replace("{0}", value);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + key);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + key);
		}
	}

	public static String getCodeMessage(String key, String name, String value) {
		try {
			return messageSourceAccessor.getMessage("ami.code.message." + key).replace("{0}", name).replace("{1}", value);
		} catch (NoSuchMessageException e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + key);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return messageSourceAccessor.getMessage("ami.code.message." + key);
		}
	}
}