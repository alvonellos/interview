package com.alvonellos.interview;

import com.alvonellos.interview.client.KanyeClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.alvonellos.interview")
@Log
public class InterviewApplication extends SpringBootServletInitializer implements InitializingBean {
	@Autowired
	KanyeClient kanyeClient;
	public static void main(String[] args) {

		SpringApplication.run(InterviewApplication.class, args);

	}

	/**
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("Interview Application Running, kanye says: " + kanyeClient.getKanyeQuote());
	}
}
