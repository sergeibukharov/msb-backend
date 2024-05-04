package com.thoughtworks.msb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class MsbApplicationTests {

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgresContainer = new  PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

	@Test
	void contextLoads() {
	}

}
