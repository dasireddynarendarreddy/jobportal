package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.nt.repositry")

public class SpringRestPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestPortalApplication.class, args);
	}

}
