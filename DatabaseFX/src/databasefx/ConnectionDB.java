/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author merve.mert
 */
public class ConnectionDB {
    
    protected static final String SERVER = "jdbc:mysql://localhost:3306/dbasefx";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "1111";
    protected Connection conn = null;
        
    protected void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    
    protected void disconnect(){
        try {
            conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
