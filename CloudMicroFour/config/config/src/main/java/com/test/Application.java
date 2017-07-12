package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import java.util.Properties;




@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) 
@EnableFeignClients
@SuppressWarnings("unused")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
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
    LocalRegionFactoryBean<Integer, Integer> accountsRegion(GemFireCache cache) {
        LocalRegionFactoryBean<Integer, Integer> accountsRegion = new LocalRegionFactoryBean<>();
        accountsRegion.setCache(cache);
        accountsRegion.setClose(false);
        accountsRegion.setName("Accounts");
        accountsRegion.setPersistent(false);
        return accountsRegion;
    }

    @Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }
    
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
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
