package com.portefeuille.services;

public interface DerbyHandle {
	
	
	

	public static enum DatabaseAtribute{
		DRIVER("org.apache.derby.jdbc.EmbeddedDriver"),
		DB_NAME("jdbcDemoDB"),
		CONNECTION_URL("jdbc:derby:%s;create=true"),
		URL_SHUTDOWN("jdbc:derby:;shutdown=true");
		
		private String value=null;
		
		public String getValue(){
			return value;
		}		
		private DatabaseAtribute(String valueArg){
			this.value = valueArg;
		}
	}
	
}
