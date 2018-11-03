package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.ClientConfigEnabledRoundRobinRule;
import com.netflix.loadbalancer.RetryRule;

/*
Spring Cloud Netflix creates an ApplicationContext for each Ribbon client name in our application. 
This is used to give the client a set of beans for instances of Ribbon components, including:

    an IClientConfig, which stores client configuration for a client or load balancer,

    an ILoadBalancer, which represents a software load balancer,

    a ServerList, which defines how to get a list of servers to choose from,

    an IRule, which describes a load balancing strategy, and

    an IPing, which says how periodic pings of a server are performed.
 */

public class RibbonConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbonRule(IClientConfig config){
		return new BestAvailableRule();
	}
}