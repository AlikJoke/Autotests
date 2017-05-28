package ru.project.autotesting.svcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("ru.project.autotesting.svcm")
@EnableScheduling
@EnableAutoConfiguration
@Configuration
public class AutoTestingSvcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTestingSvcmApplication.class, args);
	}
}
