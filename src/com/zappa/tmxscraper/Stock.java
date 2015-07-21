package com.zappa.tmxscraper;

import java.math.BigDecimal;
import java.sql.Date;

public class Stock {
	
	private String name;
	private String symbol;
	private BigDecimal currentPrice;
	private BigDecimal dailyChange;
	
	private BigDecimal open;
	private BigDecimal prevClose;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal bid;
	private BigDecimal ask;
	private int bidSize;
	private int askSize;
	private double beta;
	private double volumeWeightedAvgPrice;
	
	private double dividend;
	private double dividendYield;
	private String divFrequency;
	private Date exDivDate;
	private int sharesOut;
	private int marketCap;
	private double priceEarningsRatio;
	private double priceToBookRatio;
	private double earningsPerShare;
	private String exchange;
	
	public Stock(String name, String symbol, BigDecimal price, BigDecimal dailyChange) {
		this.name = name;
		this.symbol = symbol;
		this.currentPrice = price;
		this.dailyChange = dailyChange;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal price) {
		this.currentPrice = price;
	}

	public BigDecimal getDailyChange() {
		return dailyChange;
	}

	public void setDailyChange(BigDecimal dailyChange) {
		this.dailyChange = dailyChange;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(BigDecimal prevClose) {
		this.prevClose = prevClose;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

	public int getBidSize() {
		return bidSize;
	}

	public void setBidSize(int bidSize) {
		this.bidSize = bidSize;
	}

	public int getAskSize() {
		return askSize;
	}

	public void setAskSize(int askSize) {
		this.askSize = askSize;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getVolumeWeightedAvgPrice() {
		return volumeWeightedAvgPrice;
	}

	public void setVolumeWeightedAvgPrice(double vwap) {
		this.volumeWeightedAvgPrice = vwap;
	}

	public double getDividend() {
		return dividend;
	}

	public void setDividend(double dividend) {
		this.dividend = dividend;
	}

	public double getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(double dividendYield) {
		this.dividendYield = dividendYield;
	}

	public String getDivFrequency() {
		return divFrequency;
	}

	public void setDivFrequency(String divFrequency) {
		this.divFrequency = divFrequency;
	}

	public Date getExDivDate() {
		return exDivDate;
	}

	public void setExDivDate(Date exDivDate) {
		this.exDivDate = exDivDate;
	}

	public int getSharesOut() {
		return sharesOut;
	}

	public void setSharesOut(int sharesOut) {
		this.sharesOut = sharesOut;
	}

	public int getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(int marketCap) {
		this.marketCap = marketCap;
	}

	public double getPriceEarningsRatio() {
		return priceEarningsRatio;
	}

	public void setPriceEarningsRatio(double priceEarningsRatio) {
		this.priceEarningsRatio = priceEarningsRatio;
	}

	public double getPriceToBookRatio() {
		return priceToBookRatio;
	}

	public void setPriceToBookRatio(double priceToBookRatio) {
		this.priceToBookRatio = priceToBookRatio;
	}

	public double getEarningsPerShare() {
		return earningsPerShare;
	}

	public void setEarningsPerShare(double earningsPerShare) {
		this.earningsPerShare = earningsPerShare;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", symbol=" + symbol + ", price="
				+ currentPrice + ", dailyChange=" + dailyChange + ", open=" + open
				+ ", prevClose=" + prevClose + ", high=" + high + ", low="
				+ low + ", bid=" + bid + ", ask=" + ask + ", bidSize="
				+ bidSize + ", askSize=" + askSize + ", beta=" + beta
				+ ", vwap=" + volumeWeightedAvgPrice + ", dividend=" + dividend + ", yield="
				+ dividendYield + ", divFrequency=" + divFrequency + ", exDivDate="
				+ exDivDate + ", sharesOut=" + sharesOut + ", marketCap="
				+ marketCap + ", peRatio=" + priceEarningsRatio + ", pbRatio=" + priceToBookRatio
				+ ", eps=" + earningsPerShare + ", exchange=" + exchange + "]";
	}
	
}
