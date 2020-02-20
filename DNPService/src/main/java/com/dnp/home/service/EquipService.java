package com.dnp.home.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnp.home.mapper.EquipMapper;
import com.dnp.home.vo.DcuVO;

@Service
public class EquipService {
	static Logger logger = LogManager.getLogger(EquipService.class);

	@Autowired
	EquipMapper equipMapper;

	public List<DcuVO> getDcuList() {
		List<DcuVO> dcuList = equipMapper.selectDcuList();
		return dcuList;
	}
}