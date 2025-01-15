package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
	
	@Bean
	public DiscoveryClientRouteDefinitionLocator definitionLocator(
	    ReactiveDiscoveryClient reactiveDiscoveryClient,
	    DiscoveryLocatorProperties discoveryLocatorProperties
	) {
	    return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	


}
