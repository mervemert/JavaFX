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
public class Ogrenci {
    
       private String OgrNo;
    private String OgrAdi;
    private String OgrSadi;
    private String OgrAdres;
    private int BID;
    
    public Ogrenci(String OgrNo,String OgrAdi,String OgrSadi,
            String OgrAdres,int BID){
        this.OgrNo=OgrNo;
        this.OgrAdi=OgrAdi;
        this.OgrSadi=OgrSadi;
        this.OgrAdres=OgrAdres;
        this.BID=BID;
    }

    /**
     * @return the OgrNo
     */
    public String getOgrNo() {
        return OgrNo;
    }

    /**
     * @param OgrNo the OgrNo to set
     */
    public void setOgrNo(String OgrNo) {
        this.OgrNo = OgrNo;
    }

    /**
     * @return the OgrAdi
     */
    public String getOgrAdi() {
        return OgrAdi;
    }

    /**
     * @param OgrAdi the OgrAdi to set
     */
    public void setOgrAdi(String OgrAdi) {
        this.OgrAdi = OgrAdi;
    }

    /**
     * @return the OgrSadi
     */
    public String getOgrSadi() {
        return OgrSadi;
    }

    /**
     * @param OgrSadi the OgrSadi to set
     */
    public void setOgrSadi(String OgrSadi) {
        this.OgrSadi = OgrSadi;
    }

    /**
     * @return the OgrAdres
     */
    public String getOgrAdres() {
        return OgrAdres;
    }

    /**
     * @param OgrAdres the OgrAdres to set
     */
    public void setOgrAdres(String OgrAdres) {
        this.OgrAdres = OgrAdres;
    }

    /**
     * @return the BID
     */
    public int getBID() {
        return BID;
    }

    /**
     * @param BID the BID to set
     */
    public void setBID(int BID) {
        this.BID = BID;
    }
    
    
}
