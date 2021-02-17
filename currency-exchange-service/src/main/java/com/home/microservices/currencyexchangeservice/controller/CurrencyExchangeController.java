package com.home.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.home.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.home.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		
//		CurrencyExchange exchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(0), env.getProperty("server.port"));
		
		CurrencyExchange exchange = repository.findByFromAndTo(from, to.toUpperCase());
		
		if(exchange == null) {
			throw new RuntimeException("Unable to find the data for " + from + " to " + to);
		}
		
		String port = env.getProperty("server.port");
		exchange.setEnv(port);
		
		return exchange;

		
	}
}
