package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;


import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import com.gemstone.gemfire.cache.GemFireCache;



@Configuration
@EnableGemfireRepositories
@SuppressWarnings("unused")
@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(useDefaultFilters = false)
public class Application{
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    LocalRegionFactoryBean<String, Store> storeRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<String, Store> storeRegion = new LocalRegionFactoryBean<>();
        storeRegion.setCache(cache);
        storeRegion.setClose(false);
        storeRegion.setName("storeRepository");
        storeRegion.setPersistent(false);
        return storeRegion;
    }
    
    @Autowired
    StoreRepository storeRepository;
    
	@Bean
	public Config config() {
		return new Config();
	}     
    
	@Bean
	public AccountController accountController(){
		return new AccountController(storeRepository, config());
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
