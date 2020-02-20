package com.dnp.home.webmvc.controller;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnp.home.common.PropertyConfig;
import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.AMIException;
import com.dnp.home.service.UserService;
import com.dnp.home.vo.ResponseVO;
import com.dnp.home.vo.UserVO;

@Controller
@RequestMapping(method = RequestMethod.POST)
public class UserController extends AbsController {
	final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping("/getUserId/{userName}")
	public @ResponseBody String getUserId(@PathVariable String userName) {
		return userService.getUserId(userName);
	}

	@RequestMapping("/getUserList")
	public @ResponseBody List<UserVO> getUserList() {
		return userService.getUserList();
	}

	@RequestMapping("/test")
	public UserVO test(@RequestParam HashMap<String, String> param) throws AMIException {
		String id = param.get("id");
		String pw = param.get("pw");
		UserVO userVO = new UserVO(id, pw);

		return userVO;
	}

	@RequestMapping("/errorTest")
	public String errorTest(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws AMIException {
		throw new AMIException("로그인이 필요한 서비스입니둥");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap model) {
		return "account/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request, ModelMap model) {
		return "account/join";
	}

	@RequestMapping(value = "/addAccount")
	public @ResponseBody ResponseVO addAccount(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, String> param) throws AMIException {
		int resultCode = ExceptionConst.SUCCESS;

		String securedUserId = param.get("loginId");
		String securedPassword = param.get("password");
		String name = param.get("name");
		HttpSession session = request.getSession();
		PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
		session.removeAttribute("__rsaPrivateKey__");

		if (privateKey == null) {
			return new ResponseVO(ExceptionConst.CANNOT_FOUND_PRIVATE_KEY);
		}

		try {
			String loginId = decryptRSA(privateKey, securedUserId);
			String password = decryptRSA(privateKey, securedPassword);
//			UserVO userVO = new UserVO(loginId, password, name);
			UserVO userVO = userService.addUser(loginId, password, name);
			response.setHeader("Location", PropertyConfig.getString("ami.security.login.success.url"));

			return new ResponseVO(resultCode, userVO);
		} catch (AMIException e) {
			logger.error(e.getMessage(), e);
			return new ResponseVO(e);
		}
	}
}