/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author merve.mert
 */
public class LoginQueries extends ConnectionDB{

    public boolean login(String eposta, String sifre){
      
        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from kullanici where eposta = ? and sifre = ?";
        try {
            connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, eposta);
            ps.setString(2, sifre);
    
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else {
                return false;
            }
         
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {        
            disconnect();
        }
     return true;
    }
    
}
