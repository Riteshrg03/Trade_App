package com.synechron.assignment.domain;

import java.util.Date;

public class Trade {

	private String tradeId;
	private Date dateTime;
	private String instrumentId;
	private Integer quantity;
	private Float price;
	private Float amount;
	private String trader;

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", dateTime=" + dateTime + ", instrumentId=" + instrumentId + ", quantity="
				+ quantity + ", price=" + price + ", amount=" + amount + ", trader=" + trader + "]";
	}

	

}
