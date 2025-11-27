package com.example.lucky_spin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LuckySpinApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuckySpinApplication.class, args);
	}

}
