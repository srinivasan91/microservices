package com.home.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.microservices.config.LimitConfiguration;
import com.home.microservices.model.Limits;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	private LimitConfiguration limitConfiguration;
	
	@GetMapping("/defaultlimits")
	private Limits getDefaultLimitService() {
		
		return new Limits(1, 5);
		
	}
	
	@GetMapping("/limits")
	private Limits getLimitService() {
		return new Limits(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
	}
}
