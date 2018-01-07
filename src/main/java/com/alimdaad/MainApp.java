package com.alimdaad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MainApp {
	/*
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome To AlimdaadTrust !";
    }
	 */
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApp.class, args);
	}
	
/*	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
		
	}*/
}