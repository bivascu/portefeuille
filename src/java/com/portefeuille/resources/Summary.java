package com.portefeuille.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("summary")
public class Summary {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listHoldings(){
		return "These are my holdings";
	}
}
