package com.portefeuille.configuration;

import java.util.HashSet;
import java.util.Set;

//@ApplicationPath("/rest")
//public class AppModule extends Application{
public class AppModule{
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public AppModule(){
		System.out.println("Initializing the Main Module");
		//singletons.add(new OwnersImpl());
		//empty.add(OwnersImpl.class);
	}
	
//	@Override
//	public Set<Class<?>> getClasses(){
//		return empty;
//	}
//
//	@Override
//	public Set<Object> getSingletons(){
//		return singletons;
//	}
}
