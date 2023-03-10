package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@SpringBootApplication
public class LibraryBackEndApplication {

	@Bean
	ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
		return (request, status, model) -> status == HttpStatus.NOT_FOUND
				? new ModelAndView("index.html", Collections.emptyMap(), HttpStatus.OK)
				: null;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryBackEndApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


}
