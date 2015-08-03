package com.zappa.tmxscraper.scraper;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zappa.tmxscraper.StockHistory;

public class HistoricStockFetcher {
	
	public static StockHistory parseJsonResponse(String json, String symbol, Calendar date) {
			
		String jsonFormat = json.substring(json.indexOf("(") + 1, json.lastIndexOf(")"));
				
		JsonElement jelement = new JsonParser().parse(jsonFormat);
		JsonObject jobject = jelement.getAsJsonObject();
		
		JsonObject histObj = jobject.getAsJsonObject("history");		
		JsonObject dataObj = histObj.getAsJsonObject("eoddata");
		
		BigDecimal price = dataObj.get("close").getAsBigDecimal();
		BigDecimal open = dataObj.get("open").getAsBigDecimal();
		BigDecimal high = dataObj.get("high").getAsBigDecimal();
		BigDecimal low = dataObj.get("low").getAsBigDecimal();
		int volume = ScraperUtil.getIntFromPage(dataObj.get("sharevolume").getAsString());
		double change = dataObj.get("changepercent").getAsDouble();
		
		return new StockHistory(symbol, date, price, open, high, low, volume, change);
	}

}
