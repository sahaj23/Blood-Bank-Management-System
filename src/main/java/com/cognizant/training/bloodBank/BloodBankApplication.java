package com.cognizant.training.bloodBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableJpaRepositories
@SpringBootApplication
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}
	
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/blood-bank/").allowedMethods("*").allowedOrigins("*");
		    registry.addMapping("/donor/").allowedMethods("*").allowedOrigins("*");
		    registry.addMapping("/hospital/").allowedMethods("*").allowedOrigins("*");
		    registry.addMapping("/hospital/{email}").allowedMethods("*").allowedOrigins("*");
		    registry.addMapping("/blood-bank/{email}").allowedMethods("*").allowedOrigins("*");
		    registry.addMapping("/hospital/login").allowedOrigins("*");
		    registry.addMapping("/blood-bank/login").allowedOrigins("*");
		    registry.addMapping("/donor/login").allowedOrigins("*");
		    registry.addMapping("/blood-bank/{location}").allowedOrigins("*");
		    registry.addMapping("/blood-details/{location}").allowedOrigins("*");
		    registry.addMapping("/hospital/{location}").allowedOrigins("*");
		    registry.addMapping("/blood-details/").allowedOrigins("*");
		    registry.addMapping("/donor/{email}").allowedMethods("*").allowedOrigins("*");
	         }
	      };
	   }
}
