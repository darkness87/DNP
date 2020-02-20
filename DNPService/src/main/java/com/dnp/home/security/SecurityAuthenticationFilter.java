package com.dnp.home.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.AMIException;

public class SecurityAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//	public SecurityAuthenticationFilter(String url, AuthenticationManager authenticationManager) {
//		super(new AntPathRequestMatcher(url, HttpMethod.POST.name()));
//	}
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//		String securedLoginId = obtainUsername(request);
//		String securedPassword = obtainPassword(request);
//
//		if (securedLoginId == null) {
//			securedLoginId = "";
//		}
//
//		if (securedPassword == null) {
//			securedPassword = "";
//		}
//
//		securedLoginId = securedLoginId.trim();
//
//		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("test" + securedLoginId, securedPassword);
//		setDetails(request, authRequest);
//
//		return this.getAuthenticationManager().authenticate(authRequest);
//	}

//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//
//		// 인증 성공 시에 참조
//		System.out.println("성공하였습니다. Authentication");
//		setAuthenticationSuccessHandler(new LoginSuccessHandler());
//		super.successfulAuthentication(request, response, chain, authResult);
//	}
//
//	@Override
//	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException failed) throws IOException, ServletException {
//		// 인증 실패 시에 참조
//		System.out.println("실패하였습니다. Authentication");
//		setAuthenticationFailureHandler(new LoginFailureHandler());
//		super.unsuccessfulAuthentication(request, response, failed);
//	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String secureLoginId = request.getParameter(getUsernameParameter());
		// 로그인 폼에서 선언한 파라미터 명으로 request
		PrivateKey privateKey = (PrivateKey)request.getSession().getAttribute("__rsaPrivateKey__");
		// UserDetailService는 사용자명 + 구분자 + 추가 입력 필드를 사용자명으로 입력받게 된다

		try {
			String loginId = decryptRSA(privateKey, secureLoginId);

			return loginId;
		} catch (AMIException e) {
			return secureLoginId;
		}
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String securePassword = request.getParameter(getPasswordParameter());
		// 로그인 폼에서 선언한 파라미터 명으로 request
		PrivateKey privateKey = (PrivateKey)request.getSession().getAttribute("__rsaPrivateKey__");
		// UserDetailService는 사용자명 + 구분자 + 추가 입력 필드를 사용자명으로 입력받게 된다

		try {
			String password = decryptRSA(privateKey, securePassword);

			return password;
		} catch (AMIException e) {
			return securePassword;
		}
	}

	private String decryptRSA(PrivateKey privateKey, String securedValue) throws AMIException {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			byte[] encryptedBytes = hexToByteArray(securedValue);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
			String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.'

			return decryptedValue;
		} catch (NoSuchAlgorithmException e) {
			throw new AMIException(ExceptionConst.RSA_NO_SUCH_ALGORITHM, e);
		} catch (InvalidKeyException e) {
			throw new AMIException(ExceptionConst.RSA_INVALID_KEY_SPEC, e);
		} catch (NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			throw new AMIException(ExceptionConst.RSA_DECRYPTION_ERROR, e);
		}
	}

	/**
	 * 16진 문자열을 byte 배열로 변환한다.
	 */
	private byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() % 2 != 0) {
			return new byte[]{};
		}

		byte[] bytes = new byte[hex.length() / 2];

		for (int i = 0; i < hex.length(); i += 2) {
			byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
			bytes[(int) Math.floor(i / 2)] = value;
		}

		return bytes;
	}
}
