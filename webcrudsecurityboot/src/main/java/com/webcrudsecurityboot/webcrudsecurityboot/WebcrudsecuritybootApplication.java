package com.webcrudsecurityboot.webcrudsecurityboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.webcrudsecurityboot.webcrudsecurityboot.model"})
@SpringBootApplication
public class WebcrudsecuritybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcrudsecuritybootApplication.class, args);
	}

}
