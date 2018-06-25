package com.vyom.gae.payroll.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeServiceGaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceGaeApplication.class, args);
	}
}
