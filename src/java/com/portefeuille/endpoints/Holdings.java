package com.portefeuille.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("holdings/")
public interface Holdings {

	@GET
	@Produces(MediaType.TEXT_PLAIN) 
	@Path("{username}")
	public String listHoldings(@PathParam("username") String ticker);
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN) 
	public String listHoldings();
}
