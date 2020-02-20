package com.dnp.home.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dnp.home.mapper.UserMapper;
import com.dnp.home.vo.UserVO;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public LoginUser loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserVO userVO = userMapper.selectUser(userId);

		if (userVO == null) {
			throw new UsernameNotFoundException("ID를 찾을수 없습니다. [ " + userId + " ]");
		}

		LoginUser user = createUser(userVO);

		return user;
	}

	private LoginUser createUser(UserVO userVO) {
		LoginUser loginUser = new LoginUser(userVO);

		if (loginUser.isAdmin()) {
			loginUser.setRole("ROLE_ADMIN");
		} else {
			loginUser.setRole("ROLE_USER");
		}

		return loginUser;
	}
}