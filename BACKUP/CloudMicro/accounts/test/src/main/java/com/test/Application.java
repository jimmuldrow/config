package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
    	System.setProperty("spring.config.name", "accounts-server");
        SpringApplication.run(Application.class, args);
    }
}
