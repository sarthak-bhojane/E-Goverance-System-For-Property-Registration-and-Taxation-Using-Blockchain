/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


 
 
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
         
           con=DriverManager.getConnection("jdbc:mysql://ukyhthnhovags2go:yXXe383X2bgdfSsTjeEn@bame3ouzqanb9lcbf9oa-mysql.services.clever-cloud.com:3306/bame3ouzqanb9lcbf9oa");         
            System.out.println("Connected..");
        }
        catch(Exception e)
        {
            System.out.println("Error in connection : "+e.getMessage());
        }
        
    return con;
    }
    
    
    
}