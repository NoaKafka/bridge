package com.bridge.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BridgeApplication {
	public static void main(String[] args) {
		SpringApplication.run(BridgeApplication.class, args);
	}

}
