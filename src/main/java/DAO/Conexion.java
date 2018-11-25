/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {
	
	private static Connection CONEXION=null;
    	public static Connection getConnection() throws URISyntaxException{
        String HOST = "-----:----"; 
        String DATABASE = "----";
        String USER = "----";
        String PASS = "----";

//      URI dbUri = new URI(System.getenv("DATABASE_URL"));
//      String username = dbUri.getUserInfo().split(":")[0];
//      String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" +
                HOST + "/" + DATABASE +
                "?user=" + USER  + "&password=" + 
                PASS + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    
		   if(CONEXION == null){
			  	try {
					CONEXION = DriverManager.getConnection(dbUrl);
                        	} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
				}

				
		   }
		   return CONEXION;
	}
	
	public static void closeConnection(){
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	

}