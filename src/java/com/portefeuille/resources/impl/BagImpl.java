package com.portefeuille.resources.impl;

import javax.ws.rs.PathParam;

import com.portefeuille.resources.Bag;
import com.portefeuille.services.HtmlClient;
import com.portefeuille.services.HtmlClientImpl;



public class BagImpl implements Bag{

	public String listHoldings(@PathParam("ticker") String ticker){
		HtmlClient client = new HtmlClientImpl(); 
		return client.getCompanyDetails(ticker).toString();
	}

	public String listHoldings(){
		HtmlClient client = new HtmlClientImpl();	
		return client.getCompanyDetails("BNS").toString();
	}
}
