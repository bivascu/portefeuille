package com.portefeuille.resources.impl;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.portefeuille.endpoints.Owners;
import com.portefeuille.model.Owner;

//@Path("owners")
public class OwnersImpl implements Owners {
	
	private Map<Integer, Owner> ownerDb = Collections.synchronizedMap(new HashMap<Integer,Owner>());

	
	public OwnersImpl(){
		System.out.println("Instance of " + OwnersImpl.class.getSimpleName() + " created");
	}
	
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)	
	public Response createOwner(String jsonRequestBody){  // all non annotated parms are considered a representation of the message body. Only one param can be non annotated 
		Owner newOwner = new Owner();
		newOwner.setName("Bogdan");
		
		ownerDb.put(ownerDb.size()+1, newOwner);		
		System.out.println(ownerDb.toString());
		
		return Response.created(URI.create("/owner/" + newOwner.getName())).build();
	}

//	@Override
//	public Owner getOwner(@PathParam("id") int id){
//		final Owner result = ownerDb.get(id-1);
//		if(result == null)
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		return result; 
//	}	
}
