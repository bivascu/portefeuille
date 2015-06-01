package com.portefeuille.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.portefeuille.model.Company;

public class HtmlClientImpl implements HtmlClient {

	@Override
	public Company getCompanyDetails(String ticker) {
		
		Document doc=null;
		Company holding = new Company();
		try {
			doc = getHtmlFromPage(new URL("http://web.tmxmoney.com/quote.php?qm_symbol=RY"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		holding.setName(doc.select("div.quote-name").text());
		holding.setTicker(doc.select("div.quote-ticker.tickerLarge").html());
		holding.setExchange(doc.select("table.detailed-quote-table td acronym").attr("title"));
		
		holding.setMarketPrice(stringToBigD(doc.select("div.quote-price.priceLarge span").html()));
		holding.setChange(doc.select("div.quote-change.changeLarge").text().replaceAll(doc.select("div.quote-change.changeLarge span").text(), "").trim());		
		holding.setVolume(stringToBigD(doc.select("div.quote-volume.volumeLarge").text().replaceFirst(doc.select("div.quote-volume.volumeLarge span").text(), "").trim()));

		holding.setBuyPrice(new BigDecimal(0));
		holding.set_52WeekLow(stringToBigD(doc.select("div.week-low").text().replaceFirst(doc.select("div.week-low a").text(), "").trim()));
		holding.set_52WeekHigh(stringToBigD(doc.select("div.week-high").text().replaceFirst(doc.select("div.week-high a").text(), "").trim()));
		
		Elements elements = doc.select("table.detailed-quote-table td");		    
		for(int i=0; i<elements.size(); i++){
			//System.out.println(elements.get(i).text());
			switch(elements.get(i).text()){				
				case "High:": holding.setDayHigh(stringToBigD(elements.get(i+1).text()));break;
				case "Low:" : holding.setDayLow(stringToBigD(elements.get(i+1).text()));break;
				case "Dividend:" : holding.setDivident(stringToBigD(elements.get(i+1).text().trim()));break;
				case "P/E Ratio:" : holding.setP_E(stringToBigD(elements.get(i+1).text().trim()));break;
				case "EPS:" : holding.setEps(stringToBigD(elements.get(i+1).text().trim()));break;
				case "Yield:" : holding.setYield(stringToBigD(elements.get(i+1).text().trim()));break;
			}
		}
		System.out.println(holding.toString());
		return holding;
	}
	
	
	
	private Document getHtmlFromPage(URL path){
		Document document = null;
		try {
			document = Jsoup.connect(path.toString()).userAgent("Mozilla").get();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return document;
	}
	
	private BigDecimal stringToBigD(String hopeForNumber){
		Number localNumber=null;
		try {
			localNumber = NumberFormat.getNumberInstance(Locale.CANADA).parse(hopeForNumber);
		} catch (ParseException e) {
			System.out.println("Unable to parse String into Number: " + hopeForNumber);
			e.printStackTrace();
		}
		return localNumber == null?null:new BigDecimal(localNumber.toString());
	}
	
}
