package com.meet.room;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.meet.room.infrastructure")
public class RoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomApplication.class, args);
	}

}
