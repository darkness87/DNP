package com.dnp.home.webmvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dnp.home.consts.DNPConst;
import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.AMIException;



public class AbsController {
	static Logger logger = LogManager.getLogger(AbsController.class);
	static final String PROPERTIES_FILE_NAME = "square.properties";

	protected Map<String, String> getRSAkey(HttpServletRequest request) throws AMIException {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(DNPConst.KEY_SIZE);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = null;

			// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
			if (request.getSession().getAttribute("__rsaPrivateKey__") != null ) {
				privateKey = (PrivateKey)request.getSession().getAttribute("__rsaPrivateKey__");
			} else {
				privateKey = keyPair.getPrivate();
			}

			request.getSession().setAttribute("__rsaPrivateKey__", privateKey);
			RSAPublicKeySpec publicSpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			Map<String, String> map = new HashMap<String, String>();
			map.put("publicKeyModulus", publicKeyModulus);
			map.put("publicKeyExponent", publicKeyExponent);

			return map;
		} catch (NoSuchAlgorithmException e) {
			throw new AMIException(ExceptionConst.RSA_NO_SUCH_ALGORITHM);
		} catch (InvalidKeySpecException e) {
			throw new AMIException(ExceptionConst.RSA_INVALID_KEY_SPEC);
		}
	}

	protected String decryptRSA(PrivateKey privateKey, String securedValue) throws AMIException {
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
	protected byte[] hexToByteArray(String hex) {
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