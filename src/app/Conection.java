/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.*;

/**
 *
 * @author Mohamed
 */
public class Conection {
    Connection connection;
    Statement statement;
    PreparedStatement PreparedStatement; 
    

    public Conection() {
        try {        
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market","root","mhmd123@456ZXC");
           statement = connection.createStatement();
           
           
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
    }
    
    
}
