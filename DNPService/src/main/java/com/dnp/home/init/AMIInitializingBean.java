package com.dnp.home.init;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.dnp.home.common.PropertyConfig;
import com.dnp.home.common.PropertyMessage;

@Component
public class AMIInitializingBean implements InitializingBean {
	static Logger logger = LogManager.getLogger(AMIInitializingBean.class);

	private Properties prop = new Properties();

	private Resource[] resources = new ClassPathResource[] {
		new ClassPathResource("ami.properties")
	};

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	public void afterPropertiesSet() throws IOException {
		setPropertyConfig();
		setPropertyMessage();
	}

	private void setPropertyMessage() {
		PropertyMessage.setMessageSourceAccsssor(messageSourceAccessor);
	}

	private void setPropertyConfig() throws IOException {
		if (resources.length == 0) {
			return;
		}

		for (Resource resource : resources) {
			String key = null; String value = null;

			prop.clear();
			prop.load(resource.getInputStream());
			Enumeration<?> propertyNames = prop.propertyNames();

			while(propertyNames.hasMoreElements()) {
				key = (String)propertyNames.nextElement();
				value = prop.getProperty(key);

				if(value != null){
					value = value.trim();

					if(logger.isDebugEnabled()) {
						logger.debug(key + " = " + value);
					}

					prop.put(key, value);
				}
			}
		}

		PropertyConfig.properties = new Properties();
		PropertyConfig.properties.putAll(prop);
		logger.debug("Properties initialized");
	}

}