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
public class OgrenciQueries extends ConnectionDB{
    
   public void ogrenciKayit(Ogrenci ogr){
        try{
            connect();
            PreparedStatement yeniOgrenciKaydet=conn.prepareStatement("insert into Ogrenci values"
                    + " (?,?,?,?,?)");
            yeniOgrenciKaydet.setString(1, ogr.getOgrNo());
            yeniOgrenciKaydet.setString(2, ogr.getOgrAdi());
            yeniOgrenciKaydet.setString(3, ogr.getOgrSadi());
            yeniOgrenciKaydet.setString(4, ogr.getOgrAdres());
            yeniOgrenciKaydet.setInt(5, ogr.getBID());
            yeniOgrenciKaydet.executeUpdate();
            yeniOgrenciKaydet.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void ogrenciDegistir(Ogrenci ogr){
        try{
           connect();
            PreparedStatement ogrenciDegistir=conn.prepareStatement("update Ogrenci set"
                    + " Ogradi=?, OgrSadi=?, OgrAdres=?, BID=?  where OgrNo=?");
            ogrenciDegistir.setString(1, ogr.getOgrAdi());
            ogrenciDegistir.setString(2, ogr.getOgrSadi());
            ogrenciDegistir.setString(3, ogr.getOgrAdres());
            ogrenciDegistir.setInt(4, ogr.getBID());
            ogrenciDegistir.setString(5, ogr.getOgrNo());
            ogrenciDegistir.executeUpdate();
            ogrenciDegistir.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    public void ogrenciSil(String OgrNo){
        try{
            connect();
            PreparedStatement ogrenciSil=conn.prepareStatement("delete from Ogrenci"
                    + " where OgrNo=?");
            ogrenciSil.setString(1, OgrNo);
            ogrenciSil.executeUpdate();
            ogrenciSil.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public Ogrenci ogrenciBul(String Ogrno){
        Ogrenci ogr=null;
        try{
            connect();
            PreparedStatement ogrenciBulNo=conn.prepareStatement("Select * from Ogrenci"
                    + " where OgrNo=?");
            ogrenciBulNo.setString(1, Ogrno);
            ResultSet rs=ogrenciBulNo.executeQuery();
            rs.next();
            ogr=new Ogrenci(rs.getString("OgrNo"), rs.getString("Ogradi"), 
                    rs.getString("OgrSadi"), rs.getString("OgrAdres"), 
                    rs.getInt("BID"));
            ogrenciBulNo.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            disconnect();
        }
        return ogr;
    }
    
    public List<Ogrenci> ogrencileriGetir(){
        List<Ogrenci> sonuc=new ArrayList<Ogrenci>();
        try{
            connect();
            PreparedStatement ogrenciGetir=conn.prepareStatement("Select * from Ogrenci");
            ResultSet rs=ogrenciGetir.executeQuery();
            
            while(rs.next()){
                rs.next();
                Ogrenci ogr=new Ogrenci(rs.getString("OgrNo"), 
                        rs.getString("Ogradi"), 
                        rs.getString("OgrSadi"), 
                        rs.getString("OgrAdres"), 
                        rs.getInt("BID"));
                sonuc.add(ogr);
            }
            ogrenciGetir.close();
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
