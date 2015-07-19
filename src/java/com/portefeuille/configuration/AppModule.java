package com.portefeuille.configuration;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.portefeuille.endpoints.impl.HoldingsImpl;

@ApplicationPath("/rest")
public class AppModule extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public AppModule(){		
		System.out.println("Initializing the Main Module");
	}
	
	@Override
	public Set<Class<?>> getClasses(){
		empty.add(HoldingsImpl.class);
		return empty;
	}

	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
	
	/*
	 * This Spring integration is portable but clunky. Better to use the integration capability of the chosen Jax-RS implementation. * 
	 * 
	 */
}
