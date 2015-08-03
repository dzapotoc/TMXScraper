package com.zappa.tmxscraper;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class StockHistory {
	
	 private String symbol;
	 private Calendar date;
	 
	 private BigDecimal price;
	 private BigDecimal open;
	 private BigDecimal high;
	 private BigDecimal low;
	 private int volume;
	 private Double change;
	 
	 public StockHistory(String symbol, Calendar date, BigDecimal price, BigDecimal open, BigDecimal high, BigDecimal low, int volume, double change) {
		 this.symbol = symbol;
		 this.date = date;
		 this.price = price;
		 this.open = open;
		 this.high = high;
		 this.low = low;
		 this.volume = volume;
		 this.change = change;
	 }

	public Calendar getDate() {
		return date;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public int getVolume() {
		return volume;
	}
	 
	public double getChange() {
		return change;
	}

}
