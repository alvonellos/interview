package com.alvonellos.interview;

import com.alvonellos.interview.client.KanyeClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@SpringBootApplication
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
