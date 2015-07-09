package com.portefeuille.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("owners")
public interface Owners {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response createOwner(String jsonRequestBody);  // all non annotated parms are considered a representation of the message body. Only one param can be without annotated 
	

//	@Path("{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Owner getOwner(@PathParam("id") int id);
}
