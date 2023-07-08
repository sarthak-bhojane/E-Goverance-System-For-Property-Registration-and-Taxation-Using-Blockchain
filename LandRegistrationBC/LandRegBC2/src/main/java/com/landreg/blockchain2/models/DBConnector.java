/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.landreg.blockchain2.models;


 
 
import java.sql.*;
 
 
 
public class DBConnector {
    
 public Connection con;
    public DBConnector() 
    {
    }
    
    public Connection connect()
    {
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
         
           con=DriverManager.getConnection("jdbc:mysql://uvt2bgflwxwfmvco:EiDZ7QqmLWzmt3pmPZU5@blxo1tpvy6jqicycy7st-mysql.services.clever-cloud.com:3306/blxo1tpvy6jqicycy7st"
           		+ "");         
            System.out.println("Connected..");
        }
        catch(Exception e)
        {
            System.out.println("Error in connection : "+e.getMessage());
        }
        
    return con;
    }
    
    
    
}

