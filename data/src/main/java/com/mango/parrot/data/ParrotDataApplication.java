package com.mango.parrot.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories({"com.mango.parrot.data.repository"})
@SpringBootApplication
public class ParrotDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParrotDataApplication.class, args);

	}

}
