/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author merve.mert
 */
public class Kullanici {
    
    private int id;
    private String adi;
    private String soyadi;
    private String eposta;
    private String sifre;
    private String sifreTekrar;
    private Date dogumTarihi;

    public Kullanici() {
    }
  

    public Kullanici(String adi, String soyadi, String eposta, String sifre, String sifreTekrar, Date dogumTarihi) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.eposta = eposta;
        this.sifre = sifre;
        this.sifreTekrar = sifreTekrar;
        this.dogumTarihi = dogumTarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifreTekrar() {
        return sifreTekrar;
    }

    public void setSifreTekrar(String sifreTekrar) {
        this.sifreTekrar = sifreTekrar;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
    
    
}
