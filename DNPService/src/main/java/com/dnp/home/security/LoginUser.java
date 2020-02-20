package com.dnp.home.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dnp.home.vo.UserVO;

public class LoginUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String userName;
	private String userPassWord;
	private List<String> roles;
	private boolean isAdmin;


	public LoginUser(){
		this.roles = new ArrayList<String>();
	}

	public LoginUser(UserVO userVO) {
		this.id = userVO.getLoginId();
		this.userName = userVO.getName();
		this.userPassWord = userVO.getPassword();
		this.isAdmin = userVO.isAdmin();
		this.roles = new ArrayList<String>();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.userPassWord;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	public String getId() {
		return this.id;
	}

	public void setRole(String role) {
		this.roles.add(role);
	}

	public void setRoles(List<String> roles) {
		this.roles.addAll(roles);
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public boolean isUser() {
		return this.isAdmin == false;
	}

	@Override
	public String toString() {
		return this.id;
	}
}
