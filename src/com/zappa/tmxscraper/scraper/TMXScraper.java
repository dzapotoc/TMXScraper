package com.zappa.tmxscraper.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.zappa.tmxscraper.Stock;

public class TMXScraper {
	
	public static final String BASE_STOCK_URL = "http://web.tmxmoney.com/quote.php?qm_symbol=";
	
	public static Stock getStock(String symbol) throws Exception {
		Stock stock = null;

		Document dom = Jsoup.connect(BASE_STOCK_URL + symbol).get();
		StockResponseParser response = new StockResponseParser(dom);
		stock = response.getStock();

		return stock;
	} 

}
