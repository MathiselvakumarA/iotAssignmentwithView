package com.kone.iotassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kone.iotassignment.repository")
public class IotAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotAssignmentApplication.class, args);
	}
}
