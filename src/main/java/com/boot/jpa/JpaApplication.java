package com.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {

		System.setProperty("server.port", "3000");
		SpringApplication.run(JpaApplication.class, args);
	}

}
