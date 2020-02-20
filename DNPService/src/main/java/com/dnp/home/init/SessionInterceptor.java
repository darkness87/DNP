package com.dnp.home.init;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dnp.home.consts.AMIConst;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request
				, HttpServletResponse response, Object handler) throws Exception {
		String ignoreRequestURLs = (String) request.getAttribute("org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping");
		if (ignoreRequestURLs.indexOf("login") < 0 && ignoreRequestURLs.indexOf("join") < 0) {
			return true;
		}

		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(AMIConst.KEY_SIZE);

		KeyPair keyPair = generator.genKeyPair();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

//		if (request.getSession().getAttribute("__rsaPrivateKey__") != null ) {
//			privateKey = (PrivateKey)request.getSession().getAttribute("__rsaPrivateKey__");
//		}

		// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
		request.getSession().setAttribute("__rsaPrivateKey__", privateKey);

		RSAPublicKeySpec publicSpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

		String publicKeyModulus = publicSpec.getModulus().toString(16);
		String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

		request.setAttribute("publicKeyModulus", publicKeyModulus);
		request.setAttribute("publicKeyExponent", publicKeyExponent);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response
			, Object handler, ModelAndView modelAndView) throws Exception {
		// HTTP 요청 처리 후 수행할 로직 작성
	}
}