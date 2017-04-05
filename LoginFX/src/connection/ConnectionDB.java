/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author merve.mert
 */
public class ConnectionDB {
    
    protected final static String SERVER = "jdbc:mysql://localhost:3306/loginfx";
    protected final static String USERNAME = "root";
    protected final static String PASSWORD = "1111";
    protected Connection conn = null;
    
    protected void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//İlgili dosyanın belleğe yüklenmesini sağlar
            conn = DriverManager.getConnection(SERVER,USERNAME,PASSWORD); //veri tabanına bağlanır
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    protected void disconnect(){
        try {
            conn.close();//açık olan bağlantıyı kapatır
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }    
    
}
