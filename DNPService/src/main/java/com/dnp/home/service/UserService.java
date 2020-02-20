package com.dnp.home.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.AMIException;
import com.dnp.home.mapper.UserMapper;
import com.dnp.home.vo.UserVO;

@Service
public class UserService {
	static Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	UserMapper userMapper;

	public UserVO addUser(String loginId, String password, String name) throws AMIException {
		UserVO userVO = new UserVO(loginId, new BCryptPasswordEncoder().encode(password), name);
		try {
			userMapper.insertUser(userVO);

			return userVO;
		} catch(DuplicateKeyException e) {
			throw new AMIException(ExceptionConst.DUPLICATE_USER);
		}
	}

	public void updateDateUser(String loginId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Date currentDate = new Date();
		int currentInt = (int) (currentDate.getTime() / 1000);
		map.put("loginId", loginId);
		map.put("lastDate", currentInt);

		userMapper.updateDateUser(map);
	}

	public String getUserId(@PathVariable String userName) {
		UserVO userVO = userMapper.selectUser(userName);
		return userVO.getLoginId();
	}

	public List<UserVO> getUserList() {
		List<UserVO> userList = userMapper.selectAllUser();
		return userList;
	}
}