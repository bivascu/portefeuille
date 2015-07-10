package com.portefeuille.endpoints.impl;

import com.portefeuille.endpoints.Holdings;
import com.portefeuille.services.HtmlClient;
import com.portefeuille.services.HtmlClientImpl;



public class HoldingsImpl implements Holdings{

	
	public String listHoldings(String username){
//		HtmlClient client = new HtmlClientImpl(); 
//		return client.getCompanyDetails(ticker).toString();
		System.out.println(username);
		return null;
	}

	public String listHoldings(){
		HtmlClient client = new HtmlClientImpl();	
		return client.getCompanyDetails("BNS").toString();
	}
}
