package com.mmi.art.first.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API-Gateway for First Microservices
 * @link @EnableZuulProxy turns this application as Netflix Zuul Gateway
 * @link @EnableDiscoveryClient allows this app to register with Discovery
 * @link @EnableHystrix allows this app to be managed by Hystrix
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrix
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}
