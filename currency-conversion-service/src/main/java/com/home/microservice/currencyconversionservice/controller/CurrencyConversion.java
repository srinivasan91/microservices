package com.home.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultipl;
	private BigDecimal totalCalculateAmount;
	private String env;
	
	
	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalCalculateAmount, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultipl = conversionMultiple;
		this.totalCalculateAmount = totalCalculateAmount;
		this.env = env;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultipl() {
		return conversionMultipl;
	}
	public void setConversionMultiple(BigDecimal conversionMultipl) {
		this.conversionMultipl = conversionMultipl;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculateAmount() {
		return totalCalculateAmount;
	}
	public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
		this.totalCalculateAmount = totalCalculateAmount;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	
}
