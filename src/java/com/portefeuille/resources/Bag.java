package com.portefeuille.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.portefeuille.services.HtmlClient;
import com.portefeuille.services.HtmlClientImpl;


@Path("bag")
public class Bag {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listHoldings(){
		HtmlClient client = new HtmlClientImpl();
		client.getCompanyDetails(null);
		return "These are my holdings..";
	}
}
