/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;


/**
 *
 * @author merve.mert
 */
public class Ders {
    
    private String DKodu;
    private int Sayi;
    
    public Ders(String DKodu,int Sayi){
        this.DKodu=DKodu;
        this.Sayi=Sayi;
    }

    /**
     * @return the DKodu
     */
    public String getDKodu() {
        return DKodu;
    }

    /**
     * @param DKodu the DKodu to set
     */
    public void setDKodu(String DKodu) {
        this.DKodu = DKodu;
    }

    /**
     * @return the Sayi
     */
    public int getSayi() {
        return Sayi;
    }

    /**
     * @param Sayi the Sayi to set
     */
    public void setSayi(int Sayi) {
        this.Sayi = Sayi;
    }
    
            
    
    
    
    
    
}
