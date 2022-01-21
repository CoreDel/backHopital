package com.inti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//@ComponentScan(excludeFilters = 
//{@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfiguration.class)})
public class GestionHopitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionHopitalApplication.class, args);
	}
	//@Bean
	//public BCryptPasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
	//}
}
