package net.ysh.nemoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import net.ysh.util.LLog;

@Configuration
public class XenditServerHttpSecurityConfig {

	public XenditServerHttpSecurityConfig() {
		LLog.info(this.getClass().getName() + " is activated.");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		LLog.info("Disable CORS & CSRF");
		LLog.info("Any Request Allow Permit All");

		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.csrf().disable();

		http.authorizeHttpRequests().anyRequest().permitAll();

		return http.build();
	}
}
