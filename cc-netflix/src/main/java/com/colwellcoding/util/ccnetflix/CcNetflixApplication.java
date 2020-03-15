package com.colwellcoding.util.ccnetflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CcNetflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcNetflixApplication.class, args);
	}

}
