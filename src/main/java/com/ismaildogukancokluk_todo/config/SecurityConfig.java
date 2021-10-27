package com.ismaildogukancokluk_todo.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	/*
	 * 
	 * Since the project uses h2 in memory database, authentication is rather a relic than
	 * 
	 * actually being a secure one. Eavesdropper can easily obtain the information from the
	 * 
	 * channel. But hey, at least it asks for a password ¯\_(ツ)_/¯ ¯\_(ツ)_/¯
	 *
	*/
	

	@Override
	protected void configure
	(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		
		authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("USER","ADMIN")
		.and()
		.withUser("test").password("{noop}test").roles("USER");
		
	}
	
	@Override
	protected void configure
	(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.httpBasic()
		.and()
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/v1/user").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/v1/user/{user_id}/todo").hasRole("USER")
			.antMatchers(HttpMethod.GET, "/v1/user/{user_id}/todo/{todo_id}").hasRole("USER")
			.antMatchers(HttpMethod.POST,"/v1/user").hasRole("USER")
			.antMatchers(HttpMethod.POST,"/v1/user/{user_id}/todo").hasRole("USER")
			.antMatchers(HttpMethod.PUT, "/v1/user").hasRole("USER")
			.antMatchers(HttpMethod.PUT,"/v1/user/{user_id}/todo").hasRole("USER")
			.antMatchers(HttpMethod.DELETE,"/v1/user/{user_id}/todo/{todo_id}").hasRole("USER")
			.antMatchers(HttpMethod.DELETE,"/v1/user").hasRole("ADMIN")
			
			.and().csrf().disable().formLogin().permitAll().and().logout().permitAll();
			
	   
	}
	
	

}



























