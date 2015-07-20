package com.zappa.tmxscraper;

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
		
	}

}
