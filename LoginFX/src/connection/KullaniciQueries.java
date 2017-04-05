/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.PreparedStatement;
import model.Kullanici;

/**
 *
 * @author merve.mert
 */
public class KullaniciQueries extends ConnectionDB{
    
    public void kullaniciKayit(Kullanici kullanici){
        try {
            connect();
            PreparedStatement ps = conn.prepareStatement("insert into kullanici values"
                    + "(?,?,?,?,?,?,?)");
            ps.setInt(1, kullanici.getId());
            ps.setString(2, kullanici.getAdi());
            ps.setString(3, kullanici.getSoyadi());
            ps.setString(4, kullanici.getEposta());
            ps.setString(5, kullanici.getSifre());
            ps.setString(6, kullanici.getSifreTekrar());
            ps.setString(7, kullanici.getDogumTarihi().toString());
            
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            disconnect();
        }
        
    }
    
}
