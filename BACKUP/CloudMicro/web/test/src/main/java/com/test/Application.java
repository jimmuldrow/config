package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebAccountsService accountsService() {
		return new WebAccountsService();
	}

	@Bean
	public WebAccountsController accountsController() {
		return new WebAccountsController(accountsService());
	}
}
