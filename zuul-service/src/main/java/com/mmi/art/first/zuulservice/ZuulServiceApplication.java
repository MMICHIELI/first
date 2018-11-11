package com.mmi.art.first.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API-Gateway for First Microservices
 * @link @EnableZuulProxy turns this application as Netflix Zuul Gateway
 * @link @EnableDiscoveryClient allows this app to register with Discovery
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}
