package com.mmi.art.first.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Centralize the configuration for First Microservices
 * @link @EnableConfigServer turns this application as a ConfigurationServer
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}
}
