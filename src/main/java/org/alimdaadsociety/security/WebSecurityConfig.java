package org.alimdaadsociety.security;
/*package org.alimdaadsociety;

import org.alimdaadsociety.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	//	**********************************************************
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
//			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.antMatchers("/api/**", "/secure/**", "/secureTemplates/**").hasAnyRole("USER", "ADMIN")
//			.antMatchers("/templates/**", "/views/**", "/**")
			.anyRequest().permitAll()	
				
		.and()
		
		.formLogin()
			.loginPage("/Login")
			.loginProcessingUrl("/auth-login")
//			.failureHandler()
			.defaultSuccessUrl("/Dashboard")
			.failureUrl("/Login")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
			
		.and()
			
		.logout()
			.logoutUrl("/auth-logout")
			.logoutSuccessUrl("/Login")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.deleteCookies("JSESSIONID")
			
		.and()
		.cors().disable()
		.csrf().disable();	//To allow requests from AngularJS for login, logout

//		.exceptionHandling().accessDeniedPage("/error");
		
	}

}*/