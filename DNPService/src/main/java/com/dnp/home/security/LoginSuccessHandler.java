package com.dnp.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.dnp.home.common.PropertyConfig;
import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.service.UserService;
import com.dnp.home.vo.ResponseVO;
import com.google.gson.Gson;

 /**
  * AuthenticationSuccessHandler 를 구현한 클래스 : 인증성공후처리를 위한 클래스
  * @author pblee@cnuglobal.com
  *
  */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	public UserService userService;

	/**
	 * 로그인 성공후에 해당 URL로 이동한다
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request
										, HttpServletResponse response
										, Authentication authentication) throws IOException, ServletException {
		String loginSuccessUrl = PropertyConfig.getString("ami.security.login.success.url");
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Status", String.valueOf(HttpStatus.FOUND.value()));
		response.setHeader("Location", loginSuccessUrl);
		Gson gson = new Gson();
//		response.sendRedirect(loginSuccessUrl);
		response.getWriter().append(gson.toJson(new ResponseVO(ExceptionConst.SUCCESS)));
		userService.updateDateUser(authentication.getPrincipal().toString());
	}
}