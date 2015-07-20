package com.zappa.tmxscraper.scraper;

import static com.zappa.tmxscraper.scraper.ScraperUtil.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zappa.tmxscraper.Stock;

public class StockResponseParser {
	
	private String name;
	private String symbol;
	private BigDecimal price;
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
	private double vwap;
	
	private double dividend;
	private double yield;
	private String divFrequency;
	private Date exDivDate;
	private int sharesOut;
	private int marketCap;
	private double peRatio;
	private double pbRatio;
	private double eps;
	private String exchange;
	
	public StockResponseParser(Document dom) {
		getSimpleQuoteData(dom);
		getDetailedQuoteData(dom);
	}
	
	private void getSimpleQuoteData(Document dom) {	
		Element quoteNameDiv = dom.getElementsByClass("quote-name").first();
		name = quoteNameDiv.getElementsByTag("h2").first().text();
		
		Element quoteDataDiv = dom.getElementById("quote_data");
		
		Element quoteTickerDiv = quoteDataDiv.getElementsByClass("quote-ticker").first();
		symbol = quoteTickerDiv.text();
		
		Element quotePriceSpan = quoteDataDiv.getElementsByTag("span").first();
		price = getBigDecimalFromPage(quotePriceSpan.text());
		
		Element quoteChangeDiv = quoteDataDiv.getElementsByClass("quote-change").first();
		dailyChange = getBigDecimalFromPage(quoteChangeDiv.text().split(" ")[1]);
	}
	
	private void getDetailedQuoteData(Document dom) {
		Elements detailedQuoteTables = dom.getElementsByClass("detailed-quote-table");
		
		Elements detailedQuoteColumn = detailedQuoteTables.get(0).getElementsByTag("td");
		open = getBigDecimalFromPage(detailedQuoteColumn.get(1).text());
		high = getBigDecimalFromPage(detailedQuoteColumn.get(3).text());
		bid = getBigDecimalFromPage(detailedQuoteColumn.get(5).text());
		bidSize = getIntFromPage(detailedQuoteColumn.get(7).text());
		beta = getDoubleFromPage(detailedQuoteColumn.get(9).text());
		
		detailedQuoteColumn = detailedQuoteTables.get(1).getElementsByTag("td");
		prevClose = getBigDecimalFromPage(detailedQuoteColumn.get(1).text());
		low = getBigDecimalFromPage(detailedQuoteColumn.get(3).text());
		ask = getBigDecimalFromPage(detailedQuoteColumn.get(5).text());
		askSize = getIntFromPage(detailedQuoteColumn.get(7).text());
		vwap = getDoubleFromPage(detailedQuoteColumn.get(9).text());
		
		detailedQuoteColumn = detailedQuoteTables.get(2).getElementsByTag("td");
		dividend = getDoubleFromPage(detailedQuoteColumn.get(1).text());
		divFrequency = detailedQuoteColumn.get(3).text();
		sharesOut = getIntFromPage(detailedQuoteColumn.get(5).text());
		peRatio = getDoubleFromPage(detailedQuoteColumn.get(7).text());
		eps = getDoubleFromPage(detailedQuoteColumn.get(9).text());
		
		detailedQuoteColumn = detailedQuoteTables.get(3).getElementsByTag("td");
		yield = getDoubleFromPage(detailedQuoteColumn.get(1).text());
		exDivDate = getDateFromPage(detailedQuoteColumn.get(3).text());
		marketCap = getIntFromPage(detailedQuoteColumn.get(5).text());
		pbRatio = getDoubleFromPage(detailedQuoteColumn.get(7).text());
		exchange = detailedQuoteColumn.get(9).text();
	}
	
	public Stock getStock() {
		Stock stock = new Stock(name, symbol, price, dailyChange);
		
		stock.setOpen(open);
		stock.setHigh(high);
		stock.setBid(bid);
		stock.setBidSize(bidSize);
		stock.setBeta(beta);
		
		stock.setPrevClose(prevClose);
		stock.setLow(low);
		stock.setAsk(ask);
		stock.setAskSize(askSize);
		stock.setVwap(vwap);
		
		stock.setDividend(dividend);
		stock.setDivFrequency(divFrequency);
		stock.setSharesOut(sharesOut);
		stock.setPeRatio(peRatio);
		stock.setEps(eps);
		
		stock.setYield(yield);
		stock.setExDivDate(exDivDate);
		stock.setMarketCap(marketCap);
		stock.setPbRatio(pbRatio);
		stock.setExchange(exchange);
		
		return stock;
	}

}