/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author merve.mert
 */
public class DersQueries extends ConnectionDB{
    
    public List<Ders> dersRapor(){
        connect();
        List<Ders> sonuc=new ArrayList<Ders>();
        try{
            PreparedStatement raporGetir=conn.prepareStatement("select Dadi,count(*) as Dsayi from Ders,OgrDers where Ders.DKodu=OgrDers.DKodu group by Dadi");
            ResultSet rs=raporGetir.executeQuery();
            while(rs.next()){
                Ders drs=new Ders(rs.getString("Dadi"),rs.getInt("Dsayi"));
                sonuc.add(drs);
            }
            raporGetir.close();
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
