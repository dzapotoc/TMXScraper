package com.zappa.tmxscraper.scraper;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ScraperUtil {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
	
	public static BigDecimal getBigDecimalFromPage(String bigDecimalFromPageText) {
		BigDecimal number = null;
		try {
			number = new BigDecimal(bigDecimalFromPageText.replaceAll("[^0-9.-]",""));
		} catch (Exception e) {
			number = BigDecimal.valueOf(0);
		}
		return number;
	}
	
	public static double getDoubleFromPage(String doubleFromPageText) {
		double number;
		try {
			number = Double.parseDouble(doubleFromPageText.replaceAll("[^0-9.-]",""));
		} catch (Exception e) {
			number = 0;
		}
		return number;
	}
	
	public static int getIntFromPage(String intFromPageText) {
		int number;
		try {
			number = Integer.parseInt(intFromPageText.replaceAll("[^0-9.-]",""));
		} catch (Exception e) {
			number = 0;
		}
		return number;
	}
	
	public static Calendar getDateFromPage(String dateFromPageText) {
		Calendar date;
		try {
			date = new GregorianCalendar();
			date.setTimeInMillis(dateFormat.parse(dateFromPageText).getTime());
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}

}
