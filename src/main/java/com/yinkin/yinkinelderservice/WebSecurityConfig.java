package com.yinkin.yinkinelderservice;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.mongodb.client.model.Collation;
import com.yinkin.yinkinelderservice.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomExceptionHandler accessDeniedHandler;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	// private AccountRepository userRepository;
	// private EmployerRepository roleRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/home", "/account",
							"/js/**",
                            "/css/**",
                            "/img/**",
							"/webjars/**").permitAll() //.antMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated() 
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
			//.accessDeniedPage("/access-denied.html");
				
	}

	@Bean
	//@Override
	public UserDetailsService mongoAccountService() {
		
		// 	UserDetails user =  
		// 		withDefaultPasswordEncoder()
		// 			.username("user")
		// 			.password("password")
		// 			.roles("USER")
		// 			.build();
		

		// return new InMemoryUserDetailsManager(users);
		return new accountService();
	}

	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication()
        //         .withUser("user").password("password").roles("USER")
        //     .and()
		//         .withUser("manager").password("password").roles("MANAGER");
		bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		
		UserDetailsService userDetailsService = mongoAccountService();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
				
    }
}


