package com.alvonellos.interview;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@ComponentScan("com.alvonellos.interview")
@Log
public class InterviewApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {

		SpringApplication.run(InterviewApplication.class, args);

	}

	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {

			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.err::println);

		};
	}
}
