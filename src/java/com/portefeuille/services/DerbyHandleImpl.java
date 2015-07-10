package com.portefeuille.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyHandleImpl implements DerbyHandle {
	
	
	private void testConnection(){
		String createTable = "CREATE TABLE OWNERS  "
		        +  "(OWNER_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT OWNER_PK PRIMARY KEY, " 
		        +  " NAME VARCHAR(100) NOT NULL)" ;
		String insert = "INSERT INTO OWNERS (NAME) VALUES ('BIBI')";
		String conURL = String.format(DerbyHandle.DatabaseAtribute.CONNECTION_URL.getValue(), DerbyHandle.DatabaseAtribute.DB_NAME.getValue());
		
		try(Connection con = DriverManager.getConnection(conURL);
			Statement st = con.createStatement();)
		   {
			if(!tableExists(con)){
				st.execute(createTable);
				//st.execute(insert);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        //   ## DATABASE SHUTDOWN SECTION ## 
        /*** In embedded mode, an application should shut down Derby.
           Shutdown throws the XJ015 exception to confirm success. ***/			
           boolean gotSQLExc = false;
           try {
              DriverManager.getConnection(DerbyHandle.DatabaseAtribute.URL_SHUTDOWN.getValue());
           } catch (SQLException se)  {	
              if ( se.getSQLState().equals("XJ015") ) {
            	 //this exception is thrown to confirm success
                 gotSQLExc = true;
              }
           }
           if (!gotSQLExc) {
           	  System.out.println("Database did not shut down normally");
           }  else  {
              System.out.println("Database shut down normally");	
           }  
	}
	
	
	
	/***      Check for  WISH_LIST table    ****/
	   private static boolean tableExists (Connection con) throws SQLException {
	      try {
	         Statement s = con.createStatement();
	         s.execute("update OWNERS set NAME = 'BIBI' where 1=3");
	      }  catch (SQLException sqle) {
	         String theError = (sqle).getSQLState();
	         /** If table exists will get -  WARNING 02000: No row was found **/
	         if (theError.equals("42X05")){  // Table does not exist	         
	        	 return false;
	          }  else if (theError.equals("42X14") || theError.equals("42821"))  {
	        	  System.out.println("tableExists: Incorrect table definition. Drop table OWNER and rerun this program");
	             throw sqle;   
	          } else { 
	             System.out.println("tableExists: Unhandled SQLException" );
	             throw sqle; 
	          }
	      }
	      return true;
	   }  

	public static void main(String[] args) {
		DerbyHandleImpl impl = new DerbyHandleImpl();
		impl.testConnection();
		
	}
}
