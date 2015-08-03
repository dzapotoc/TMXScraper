package com.zappa.tmxscraper;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.zappa.tmxscraper.scraper.TMXScraper;

public class ScraperTest {
	
	public static final String BASE_STOCK_URL = "http://web.tmxmoney.com/quote.php?qm_symbol=";

	public static void main(String[] args) {

		String[] symbols = {"RCI.B", "SU", "BNS", "BMO", "XXXX", "CNR", "L", "MFC", "SLF", "VUN", "N:US"};
		
		for (String symbol : symbols) {
			try {
				System.out.println(TMXScraper.getStock(symbol));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Calendar date = new GregorianCalendar(2005, 11, 1);
		try {
			StockHistory stock = TMXScraper.getHistory(symbols[0], date);
			System.out.println(stock.getPrice() + " " + stock.getChange());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
