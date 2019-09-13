package com.orioltristany.oauth2authorizationserveronly.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurerAdapterImpl extends WebSecurityConfigurerAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		logger.trace("configure-HttpSecurity");
		http.authorizeRequests().antMatchers("/oauth/revoke**", "/inmemoryapplicationscontroller**").anonymous()
				.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		logger.trace("configure-WebSecurity");
		web.ignoring().antMatchers("/oauth/revoke**", "/inmemoryapplicationscontroller");
	}
}