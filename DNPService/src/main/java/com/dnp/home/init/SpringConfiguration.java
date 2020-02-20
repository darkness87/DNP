package com.dnp.home.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dnp.home.common.PropertyConfig;

@Configuration
public class SpringConfiguration implements WebMvcConfigurer {
	@Autowired
	private SessionInterceptor httpInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludeList = PropertyConfig.getList("ami.interceptor.exclude.list");
		registry.addInterceptor(httpInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(excludeList);
	}

//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//		resolvers.add(new UserHandlerArgumentResolver());
//		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
//	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:com/cnu/amisystem/viewmessages");
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource());
	}
}