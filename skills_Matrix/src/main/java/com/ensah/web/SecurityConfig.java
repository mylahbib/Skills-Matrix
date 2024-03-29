package com.ensah.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
		 auth.inMemoryAuthentication()
		 .withUser("youssef").password("{noop}1234").roles("USER");
		 
	}
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		 http.authorizeRequests().antMatchers("/admin/form","/admin/delete","/admin/save","/addCat","/index","/addCategorie","/admin/users","/admin/").hasRole("ADMIN"); 
		 http.exceptionHandling().accessDeniedPage("/403");
		 http.authorizeRequests().antMatchers("/index","/addCategorie","/saveCategorie",
				 "/addCompetence","/saveCompetence","/niveau/{id}","/skills","/histo").hasRole("USER");
	}
	 
	
}
