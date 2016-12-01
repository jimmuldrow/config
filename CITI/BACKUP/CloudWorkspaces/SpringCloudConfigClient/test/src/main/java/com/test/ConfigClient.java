package com.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class ConfigClient {
     
    @Value("${user.role}")
    private String role;
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
 
    @RequestMapping(
      value = "/whoami/{username}", 
      method = RequestMethod.GET, 
      produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
    }
}