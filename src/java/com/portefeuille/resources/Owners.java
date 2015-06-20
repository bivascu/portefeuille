package com.portefeuille.resources;

import javax.ws.rs.core.Response;

//@Path("owners")
public interface Owners {
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)	
	public Response createOwner(String jsonRequestBody);  // all non annotated parms are considered a representation of the message body. Only one param can be non annotated 
	

//	@Path("{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Owner getOwner(@PathParam("id") int id);
}
