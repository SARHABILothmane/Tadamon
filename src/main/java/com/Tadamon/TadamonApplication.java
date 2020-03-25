package com.Tadamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TadamonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TadamonApplication.class, args);
	}

}
