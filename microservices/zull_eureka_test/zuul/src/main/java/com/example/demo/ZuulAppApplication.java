package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulAppApplication.class, args);
	}

	@Bean
	public CustomFilter preFilter() {
		return new CustomFilter();
	}
}
