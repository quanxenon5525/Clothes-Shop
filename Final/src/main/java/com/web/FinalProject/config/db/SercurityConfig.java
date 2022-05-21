package com.web.FinalProject.config.db;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.web.FinalProject.service.CustomUserDetailService;

@Configuration
@Order(1)
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired HttpServletResponse response; 


	@Autowired
	CustomUserDetailService customerUserDetailService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerProduct/AddProduct").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerProduct/ListProduct").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerBrand/AddBrand").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerBrand/ListBrand").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerCategory/AddCategory").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerCategory/ListCategory").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerOrder/ListWait").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerProduct/EditProduct/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerBrand/EditBrand/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerCategory/EditCategory/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/ManagerOrder/DetailOrder/**").hasAuthority("ADMIN");



		http.authorizeRequests()
		.antMatchers("/**",
				"/login/vendor/**",
				"/login/js/**",
				"/login/css/**",
				"/login/fonts/**",
				"/login/images/**",
				"/home/css/**",
				"/home/img/**",
				"/home/js/**",
				"/home/mail/**",
				"/home/scss/**",
				"/home/lib/**",
				"/categories/img/**",
				"/collection/img/**",
				"/logout", 
				"/checkout",
				"/cart/**",
				"/detail",
				"/all-cookies"
		
			
				).permitAll()
		
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/")
		.failureUrl("/login?sucess=false")
		.loginProcessingUrl("/j_spring_security_check");

	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());

	}
}
