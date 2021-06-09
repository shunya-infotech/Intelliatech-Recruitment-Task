package com.shunya.spring_samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.shunya.spring_samples.repository")
//@EntityScan("com.shunya.spring_samples.model")
@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class })
public class SpringSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSamplesApplication.class, args);
	}

}
