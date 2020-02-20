package com.dnp.home.webmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnp.home.exception.AMIException;

@RequestMapping("/error")
@Controller
public class ExceptionHandlingController {
	@ExceptionHandler(AMIException.class)
	public String loginAuthError(HttpServletRequest req, HttpServletResponse res, ModelMap model, AMIException e) {
		model.addAttribute("exception", e);
		model.addAttribute("url", req.getRequestURL());

		return "error";
	}
}