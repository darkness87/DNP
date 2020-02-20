package com.dnp.home.security;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.dnp.home.common.PropertyMessage;
import com.dnp.home.consts.ExceptionConst;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
	final Logger logger = LogManager.getLogger(SecurityAuthenticationProvider.class);

	private SecurityUserDetailsService securityUserDetailsService;

	private PasswordEncoder passwordEncoder;

	AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String userPassword = (String) authentication.getCredentials();
		LoginUser user = null;

		Collection<? extends GrantedAuthority> authorities = null;
		try {
			// 사용자를 조회한다.
			user = securityUserDetailsService.loadUserByUsername(userId);

			if (user == null || !passwordEncoder.matches(userPassword, user.getPassword())){
				throw new BadCredentialsException(PropertyMessage.getCodeMessage(ExceptionConst.INVALID_PASSWORD));
			}

			// IP 접속이 제한 되어 있다면....?
//			List<ComUserAlowIp> comUserAlowIpList = securityUserDetailsService.findComUserAlowIpByUserMngtSeq(((SecurityUser)user).getComUserMngt());
//			if(comUserAlowIpList != null && !comUserAlowIpList.isEmpty()){ // 없으면 통과
//				pathMatcher.setPathSeparator(".");
//				boolean isAlowIp = false;
//				String remoteAddress = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();
//				for(ComUserAlowIp comUserAlowIp: comUserAlowIpList){
//					if(pathMatcher.match(comUserAlowIp.getAlowIp(), remoteAddress)){
//						isAlowIp = true;
//						break;
//					}
//				}
//
//				if(!isAlowIp){
//					throw new BadCredentialsException("is Not Allow IP Address : " + remoteAddress);
//				}
//			}
			// 권한 목록 반환
			authorities = user.getAuthorities();
		} catch(UsernameNotFoundException e) {
//			logger.info(e.getMessage(), e);
			throw e;
		} catch(BadCredentialsException e) {
//			logger.info(e.getMessage(), e);
			throw e;
		}

		return new UsernamePasswordAuthenticationToken(user, userPassword, authorities);
	}


	public SecurityUserDetailsService getSecurityUserDetailsService() {
		return securityUserDetailsService;
	}


	public void setSecurityUserDetailsService(SecurityUserDetailsService securityUserDetailsService) {
		this.securityUserDetailsService = securityUserDetailsService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}
}