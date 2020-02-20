package com.dnp.home.webmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnp.home.exception.AMIException;
import com.dnp.home.security.LoginUser;

@Controller
public class MainController {
	final Logger logger = LogManager.getLogger(MainController.class);

	@RequestMapping("/main")
	public String main(@AuthenticationPrincipal LoginUser user, ModelMap model) throws AMIException {
		model.addAttribute("user", user);

		return "main";
	}

	@RequestMapping("/dashboard")
	public String dashboard(@AuthenticationPrincipal LoginUser user, ModelMap model) throws AMIException {
		model.addAttribute("user", user);

		return "dashboard";
	}
}