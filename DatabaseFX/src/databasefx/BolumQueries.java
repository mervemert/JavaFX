/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author merve.mert
 */
public class BolumQueries extends ConnectionDB{
    
    public ObservableList<Bolum> bolumleriGetir(){
        ObservableList<Bolum> sonuc=FXCollections.observableArrayList();
        try{
            connect();
            PreparedStatement bolumGetir=conn.prepareStatement("Select * from Bolum");
            ResultSet rs=bolumGetir.executeQuery();
            
            while(rs.next()){
                Bolum blm=new Bolum(rs.getInt("BID"),rs.getString("Badi"));
                sonuc.add(blm);
            }
            bolumGetir.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
        
        return sonuc;
    }
    
    public int idGetir(String badi){
        int sonuc=0;
        try{
            connect();
            PreparedStatement bolumGetir=conn.prepareStatement("Select BID from Bolum where Badi=?");
            bolumGetir.setString(1, badi);
            ResultSet rs=bolumGetir.executeQuery();
            rs.next();
            sonuc=rs.getInt(1);
            bolumGetir.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
        return sonuc;
    }
    
    public String isimGetir(int bid){
        String sonuc="";
        try{
            connect();
            PreparedStatement bolumGetir=conn.prepareStatement("Select Badi from Bolum where BID=?");
            bolumGetir.setInt(1, bid);
            ResultSet rs=bolumGetir.executeQuery();
            rs.next();
            sonuc=rs.getString(1);
            bolumGetir.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
        return sonuc;
    }
    
}
