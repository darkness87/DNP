package com.dnp.home.webmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 홈 > TOU
 * @author pblee@cnuglobal.com
 *
 */
@Controller
@RequestMapping("/tou")
public class TouController {
	final Logger logger = LogManager.getLogger(TouController.class);

//	@RequestMapping("/main")
//	public String main() throws AMIException {
//		return "main";
//	}
}