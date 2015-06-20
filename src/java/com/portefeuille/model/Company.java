package com.portefeuille.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Company {
	
	private String name;
	private String ticker;
	private String exchange;
	
	private BigDecimal buyPrice;
	private BigDecimal marketPrice;
	private String change;
		
	private BigDecimal volume;
	private BigDecimal dayLow;
	private BigDecimal dayHigh;
	private BigDecimal _52WeekLow;
	private BigDecimal _52WeekHigh;
	private BigDecimal divident;
	private BigDecimal P_E;
	private BigDecimal eps;
	private BigDecimal yield;	
	

	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public BigDecimal getDayLow() {
		return dayLow;
	}
	public void setDayLow(BigDecimal dayLow) {
		this.dayLow = dayLow;
	}
	public BigDecimal getDayHigh() {
		return dayHigh;
	}
	public void setDayHigh(BigDecimal dayHigh) {
		this.dayHigh = dayHigh;
	}
	public BigDecimal get_52WeekLow() {
		return _52WeekLow;
	}
	public void set_52WeekLow(BigDecimal _52WeekLow) {
		this._52WeekLow = _52WeekLow;
	}
	public BigDecimal get_52WeekHigh() {
		return _52WeekHigh;
	}
	public void set_52WeekHigh(BigDecimal _52WeekHigh) {
		this._52WeekHigh = _52WeekHigh;
	}
	public BigDecimal getDivident() {
		return divident;
	}
	public void setDivident(BigDecimal divident) {
		this.divident = divident;
	}
	public BigDecimal getP_E() {
		return P_E;
	}
	public void setP_E(BigDecimal p_E) {
		P_E = p_E;
	}
	public BigDecimal getEps() {
		return eps;
	}
	public void setEps(BigDecimal eps) {
		this.eps = eps;
	}
	public BigDecimal getYield() {
		return yield;
	}
	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ").append(name).append(";").append(System.lineSeparator());
		builder.append("Ticker: ").append(ticker).append(";").append(System.lineSeparator());
		builder.append("Exchange: ").append(exchange).append(";").append(System.lineSeparator());
		builder.append("BuyPrice: ").append(buyPrice).append(";").append(System.lineSeparator());		
		builder.append("MarketPrice: ").append(marketPrice).append(";").append(System.lineSeparator());
		builder.append("Change: ").append(change).append(";").append(System.lineSeparator());
		builder.append("Volume: ").append(volume).append(";").append(System.lineSeparator());
		builder.append("DayLow: ").append(dayLow).append(";").append(System.lineSeparator());
		builder.append("DayHigh: ").append(dayHigh).append(";").append(System.lineSeparator());
		builder.append("52WeekLow: ").append(_52WeekLow).append(";").append(System.lineSeparator());
		builder.append("52WeekHigh: ").append(_52WeekHigh).append(";").append(System.lineSeparator());
		builder.append("Divident: ").append(divident).append(";").append(System.lineSeparator());
		builder.append("P/E: ").append(P_E).append(";").append(System.lineSeparator());
		builder.append("EPS: ").append(eps).append(";").append(System.lineSeparator());
		builder.append("Yield: ").append(yield).append(";").append(System.lineSeparator());
		
		return builder.toString();
	}
		
}
