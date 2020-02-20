package com.dnp.home.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dnp.home.common.PropertyConfig;

/**
 * AbstractSecurityWebApplicationInitializer 를 상속한 클래스 : 시큐어리티 초기화 클래스
 * WebSecurityConfigurerAdapter를 상속한 클래스 : 시큐어리티에 대한 설정 클래스
 * AuthenticationSuccessHandler 를 구현한 클래스 : 인증성공후처리를 위한 클래스
 * UserDetailsService 를 구현한 클래스 : 실제 인증과정을 처리하는 클래스
 * HandlerMethodArgumentResolver를 구현한 클래스 : 컨트롤러에 도착전에 파리미터를 처리하는 클래스
 * @author pblee@cnuglobal.com
 */
@Configuration
@EnableWebSecurity	// 웹보안 설정
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//	@Autowired
	//	private UserAuthenticationProvider authenticationProvider;

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

	@Autowired
	DataSource dataSource;
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	@Autowired
	private LoginFailureHandler loginFailureHandler;
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	@Autowired
	private SecurityAuthenticationProvider securityAuthenticationProvider;

	/*
	 * access(String) 주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용
	 * anonymous() 익명의 사용자의 접근을 허용
	 * authenticated() 인증된 사용자의 접근을 허용
	 * denyAll() 무조건 접근을 허용하지 않음
	 * fullyAuthenticated() 사용자가 완전히 인증되면 접근을 허용(기억되지 않음)
	 * hasAnyAuthority(String...) 사용자가 주어진 권한 중 어떤 것이라도 있다면 접근을 허용
	 * hasAnyRole(String...) 사용자가 주어진 역할 중 어떤 것이라도 있다면 접근을 허용
	 * hasAuthority(String) 사용자가 주어진 권한이 있다면 접근을 허용
	 * hasIpAddress(String) 주어진 IP로부터 요청이 왔다면 접근을 허용
	 * hasRole(String) 사용자가 주어진 역할이 있다면 접근을 허용
	 * not() 다른 접근 방식의 효과를 무효화
	 * permitAll() 무조건 접근을 허용
	 * rememberMe() 기억하기를 통해 인증된 사용자의 접근을 허용
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] permitAll = PropertyConfig.getString("dnp.security.permit.all").split(",");
		String[] permitAdmin = PropertyConfig.getString("dnp.security.permit.admin").split(",");
		String[] permitUser = PropertyConfig.getString("dnp.security.permit.user").split(",");
		http.authorizeRequests()
			.antMatchers(permitAll).permitAll()
			.antMatchers(permitAdmin).hasRole("ADMIN")			// 내부적으로 접두어 "ROLE_"가 붙는다.
			.antMatchers(permitUser).hasAnyRole("ADMIN", "USER")	// 내부적으로 접두어 "ROLE_"가 붙는다.
			.anyRequest().authenticated().and().addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		String loginPage = PropertyConfig.getString("dnp.security.login.page");
		String loginProcessingUrl = PropertyConfig.getString("dnp.security.login.processing.url");
		String usernameParameter = PropertyConfig.getString("dnp.security.parameter.id");
		String passwordParameter = PropertyConfig.getString("dnp.security.parameter.pw");
//		String failureUrl = PropertyConfig.getString("dnp.security.failure.url");
		http.formLogin()
			.loginPage(loginPage)					// default
			.loginProcessingUrl(loginProcessingUrl)
//			.failureUrl(failureUrl)					// LoginFailureHandler.class로 대체
//			.defaultSuccessUrl("/home")				// LoginSuccessHandler.class로 대체
			.usernameParameter(usernameParameter)
			.passwordParameter(passwordParameter)
			.failureHandler(loginFailureHandler)
			.successHandler(loginSuccessHandler)
			.permitAll().and();

		String logoutProcessingUrl = PropertyConfig.getString("dnp.security.logout.processing.url");
		String logoutSuccessUrl = PropertyConfig.getString("dnp.security.logout.success.url");
		http.logout().deleteCookies("remove")
			.invalidateHttpSession(true)			// 로그 아웃시 세션을 무효화
			.clearAuthentication(true)				// 로그 아웃시 인증정보를 지움
			.logoutRequestMatcher(new AntPathRequestMatcher(logoutProcessingUrl))
//			.logoutUrl("/logout")					// default
			.logoutSuccessUrl(logoutSuccessUrl)
			.permitAll().and();

		http.csrf().disable();

		http.sessionManagement()
			.maximumSessions(1)						// 한계정당 1명만 집어넣음
			.maxSessionsPreventsLogin(false);		// 중복 로그인 시 기존 로그인 사용자에 대한 모든 권한 제거
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	/**
	 * BCryptPasswordEncoder: bcrypt 해시 알고리즘을 이용하여 입력받은 데이터를 암호화한다
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityAuthenticationFilter authenticationFilter() throws Exception {
		SecurityAuthenticationFilter securityAuthenticationFilter = new SecurityAuthenticationFilter();
		securityAuthenticationFilter.setAuthenticationManager(this.authenticationManagerBean());
		securityAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
		securityAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler);
		securityAuthenticationFilter.setUsernameParameter("loginId");
		securityAuthenticationFilter.setPasswordParameter("password");
		securityAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/authenticate","POST"));

		return securityAuthenticationFilter;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		securityAuthenticationProvider.setSecurityUserDetailsService(securityUserDetailsService);
		securityAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		auth.authenticationProvider(securityAuthenticationProvider);
	}

	/**
	 * configureGlobal(AuthenticationManagerBuilder auth) 데이터베이스 인증용 Provider
	 * ※ securityAuthenticationProvider로 대체한다.
	 * @return
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(securityUserDetailsService);
//	}
//	@Deprecated
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(securityUserDetailsService);
//		authenticationProvider.setPasswordEncoder(passwordEncoder()); //패스워드를 암호활 경우 사용한다
//
//		return authenticationProvider;
//	}
}