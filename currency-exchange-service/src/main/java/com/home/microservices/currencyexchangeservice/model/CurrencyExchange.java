package com.home.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

	public CurrencyExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private long id;
	
	@Column(name ="currency_from")
	private String from;
	
	@Column(name = "currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private String env;
	
	
	public CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.env = env;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	
	
	
	
	
}
