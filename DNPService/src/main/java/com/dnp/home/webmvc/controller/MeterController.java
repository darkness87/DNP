package com.dnp.home.webmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnp.home.exception.DNPException;

/**
 * 홈 > 설비관리
 * @author pblee@cnuglobal.com
 *
 */
@Controller
@RequestMapping("/meter")
public class MeterController {
	final Logger logger = LogManager.getLogger(MeterController.class);

	@RequestMapping("/")	// DCU
	public String equip() throws DNPException {
		return "meter/body";
	}

	@RequestMapping("/fixedMeter")	// 현재 / 정기 검침
	public String fixedMeter() throws DNPException {
		return "meter/fixedMeter";
	}

	@RequestMapping("/maximumDemand")	// 현재 / 정기 최대수요
	public String maximumDemand() throws DNPException {
		return "meter/maximumDemand";
	}
}