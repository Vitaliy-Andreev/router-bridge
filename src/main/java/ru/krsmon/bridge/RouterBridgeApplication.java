package ru.krsmon.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableRetry
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.krsmon.bridge.domain.repository")
public class RouterBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouterBridgeApplication.class, args);
	}

}
