/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;

/**
 *
 * @author ecir
 */
public class Bolum {
    private int BID;
    private String Badi;
    
    public Bolum(int BID,String Badi){
        this.BID=BID;
        this.Badi=Badi;
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

    /**
     * @return the Badi
     */
    public String getBadi() {
        return Badi;
    }

    /**
     * @param Badi the Badi to set
     */
    public void setBadi(String Badi) {
        this.Badi = Badi;
    }
}
