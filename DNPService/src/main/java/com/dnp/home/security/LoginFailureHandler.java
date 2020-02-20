package com.dnp.home.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.vo.ResponseVO;
import com.google.gson.Gson;

/**
 * AuthenticationFailureHandler 를 구현한 클래스 : 인증성공후실패시를 위한 클래스
 * @author pblee@cnuglobal.com
 *
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
	final Logger logger = LogManager.getLogger(LoginFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		int exceptionCode = ExceptionConst.FAIL;
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");

		if (exception instanceof BadCredentialsException) {		// 비밀번호 오류시
			logger.error(exception.getMessage(), exception);
			exceptionCode = ExceptionConst.INVALID_PASSWORD;
		} else if (exception instanceof LockedException) {		// 잠긴 계정의경우
			exceptionCode = ExceptionConst.LOCKED_USER;
		} else if(exception instanceof UsernameNotFoundException) {	// 로그인 ID가 없는경우
			exceptionCode = ExceptionConst.INVALID_LOGINID;
		}

		Gson gson = new Gson();
		response.getWriter().append(gson.toJson(new ResponseVO(exceptionCode)));
	}
}
