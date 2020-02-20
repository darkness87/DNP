package com.dnp.home.webmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.AMIException;
import com.dnp.home.service.EquipService;
import com.dnp.home.util.StringUtil;
import com.dnp.home.vo.ListVO;
import com.dnp.home.vo.ResponseVO;

/**
 * 홈 > 설비관리
 * @author pblee@cnuglobal.com
 *
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	final Logger logger = LogManager.getLogger(EquipmentController.class);

	@Autowired
	EquipService equipService; 

	@RequestMapping("/")	// DCU
	public String equip() throws AMIException {
		return "equip/body";
	}

	@RequestMapping("/dcu")	// DCU
	public String dcu() throws AMIException {
		return "equip/dcu";
	}

	@RequestMapping("/getDcuList")	// DCU
	public @ResponseBody ResponseVO getDcuList() throws AMIException {
		int resultCode = ExceptionConst.SUCCESS;

		ListVO listVO = StringUtil.convertListToObject(equipService.getDcuList());
		return new ResponseVO(resultCode, listVO);
	}

	@RequestMapping("/meter")	// METER
	public String meter() throws AMIException {
		return "equip/meter";
	}

	@RequestMapping("/transformer")	// 변압기
	public String transformer() throws AMIException {
		return "equip/transformer";
	}

	@RequestMapping("/hierarchy")	// 계층구조
	public String hierarchy() throws AMIException {
		return "equip/hierarchy";
	}
}