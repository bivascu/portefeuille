package com.portefeuille.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bag/")
public interface Bag {

	@GET
	@Produces(MediaType.TEXT_PLAIN) // don't like query params except for complex filter. User Pathparam.
	@Path("{ticker}")
	public String listHoldings(@PathParam("ticker") String ticker);
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN) // don't like query params except for complex filter. User Pathparam. 
	public String listHoldings();
}
