package com.dnp.home.mapper;

import java.util.List;
import java.util.Map;

import com.dnp.home.vo.UserVO;

public interface UserMapper {
	public int insertUser(UserVO userVO);
	public void updateDateUser(Map<String, Object> map);
	public List<UserVO> selectAllUser();
	public UserVO selectUser(String userId);
	public UserVO selectSecurityUser(String userId, String userPassword);
	public void test();
}