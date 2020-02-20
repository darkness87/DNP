package com.dnp.home.webmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnp.home.exception.DNPException;

/**
 * 홈 > 장애관리
 * @author pblee@cnuglobal.com
 *
 */
@Controller
@RequestMapping("/fault")
public class FaultController {
	final Logger logger = LogManager.getLogger(FaultController.class);

	@RequestMapping("/establish")	// 미터 변동/신설
	public String establish() throws DNPException {
		return "establish";
	}

	// 왜케 네이밍 맘에 안들지...
	@RequestMapping("/powerOutage")	// 정전 / 복전
	public String powerOutage() throws DNPException {
		return "powerOutage";
	}
}