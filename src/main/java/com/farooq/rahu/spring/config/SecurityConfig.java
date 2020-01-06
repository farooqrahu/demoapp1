package com.farooq.rahu.spring.config;

import com.farooq.rahu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Furkan Bayraktar
 * Date: 7/11/14
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    // Enable Basic Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}
	*/
    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/angular/**",
                        "/app/**",
                        "/bootstrap/**",
                        "/img/**",
                        "/scripts/**",
                        "/styles/**",
                        "/**",
                        "/vendors/**",
                        "/demo/**",
                        "/snippets/**", "/nav", "/index", "/login", "/app/**", "/favicon.ico" , "/downloadProduct").permitAll()
                .anyRequest().fullyAuthenticated().and()
                .httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable();

//		http.httpBasic(); // Enable Basic Authentication
    }
}
