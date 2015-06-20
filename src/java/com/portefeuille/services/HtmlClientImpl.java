package com.portefeuille.services;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.portefeuille.model.Company;

public class HtmlClientImpl implements HtmlClient {

	@Override
	public String getCompanyDetails(String ticker) {
		
		Document doc=null;
		Company holding = new Company();
		String rootPath = "http://web.tmxmoney.com/quote.php?qm_symbol=%s";
		URL url =null;
		try {
			 url = new URL(String.format(rootPath, ticker));
		} catch (MalformedURLException e1) {
			System.out.println("Counld not build URL.");
			e1.printStackTrace();
			return null;
		}		
		
		doc = getHtmlFromPage(url);
		
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
		//System.out.println(holding.toString());
		
		return object2Json(holding);
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
	
	private String object2Json(Object object){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		StringWriter stringObject = new StringWriter();
		try {
			mapper.writeValue(stringObject, object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringObject.toString();
	}
	
	
	public static void main(String[] args) {
		HtmlClientImpl client = new HtmlClientImpl();
		Company comp = new Company();
		comp.setName("My Company");
		comp.setTicker("Tic");
		System.out.println(client.object2Json(comp));
		
	}
}
