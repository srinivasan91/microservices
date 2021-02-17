package com.home.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.home.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")

	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		System.out.println("Response code of Currency Exchange service :" + responseEntity.getStatusCode());
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		System.out.println("currencyExchange.getConversionMutiple() : " + currencyConversion.getConversionMultipl());
		System.out.println("currencyExchange.getFrom) : " + currencyConversion.getFrom());
		System.out.println("currencyExchange.getTo() : " + currencyConversion.getTo());

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultipl(), quantity.multiply(currencyConversion.getConversionMultipl()),
				currencyConversion.getEnv() + " - " + "Rest Template");

//		return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")

	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion retrievedCurrencyExchange = proxy.retrieveCurrencyExchange(from, to);
		
		System.out.println("retrieved-feign currencyExchange.getConversionMutiple() : " + retrievedCurrencyExchange.getConversionMultipl());
		System.out.println("retrieved-feign currencyExchange.getFrom) : " + retrievedCurrencyExchange.getFrom());
		System.out.println("retrieved-feign currencyExchange.getTo() : " + retrievedCurrencyExchange.getTo());

		return new CurrencyConversion(retrievedCurrencyExchange.getId(), from, to, quantity,
				retrievedCurrencyExchange.getConversionMultipl(), quantity.multiply(retrievedCurrencyExchange.getConversionMultipl()),
				retrievedCurrencyExchange.getEnv() + " - " + "Feign");

//		return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
	}
}
