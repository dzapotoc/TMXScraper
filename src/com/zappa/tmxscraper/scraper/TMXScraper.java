package com.zappa.tmxscraper.scraper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.zappa.tmxscraper.*;

public class TMXScraper {
	
	public static final String BASE_STOCK_URL = "http://web.tmxmoney.com/quote.php?qm_symbol=";
	public static final String HIST_STOCK_URL = "http://web.tmxmoney.com/json/getPriceHistory.json.php?callback=jsonp1437957432519&_=1437956663078";
	//http://web.tmxmoney.com/json/getPriceHistory.json.php?callback=jsonp1437957432519&_=1437956663078&qm_symbol=RCI.B&date=2005%2F12%2F12
	
	public static Stock getStock(String symbol) throws Exception {
		Stock stock = null;

		Document dom = Jsoup.connect(BASE_STOCK_URL + symbol).get();
		StockResponseParser response = new StockResponseParser(dom);
		stock = response.getStock();

		return stock;
	}
	
	public static StockHistory getHistory(String symbol, Calendar date) throws Exception {
		URL url = new URL(constructHistoryUrl(symbol, date));
		String urlContent = getURLContent(url);
		
		return HistoricStockFetcher.parseJsonResponse(urlContent, symbol, date);
	}
	
	private static String getURLContent(URL url) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder builder = new StringBuilder();
			
		String line;
		while ((line = reader.readLine()) != null)
			builder.append(line);	
		reader.close();
		
		return builder.toString();
	}
	
	private static String constructHistoryUrl(String symbol, Calendar date) {
		String symParam = "&qm_symbol=" + symbol;
		String dateParam = "&date=" + date.get(Calendar.YEAR) + "%2F" + (date.get(Calendar.MONTH) + 1) + "%2F" + date.get(Calendar.DATE);
		return HIST_STOCK_URL + symParam + dateParam;
	}

}
