package com.smart.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class MyConfig {
	

	@Autowired
	CustomUserDetails custom;
	
	@Bean
	public UserDetailsService getUserDetailService() {
		return new CustomUserDetails();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(custom);
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/usuario/**").hasRole("USER")
        .requestMatchers("/**").permitAll().and().formLogin()
        .loginPage("/signin")
        .loginProcessingUrl("/dologin")
        .defaultSuccessUrl("/usuario/index")
        .failureUrl("/login_fail")
        .and().csrf().disable();
     
        
        
        return http.build();
    }
}
