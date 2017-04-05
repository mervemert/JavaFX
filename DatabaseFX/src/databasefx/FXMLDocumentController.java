/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author merve.mert
 */
public class FXMLDocumentController implements Initializable {
    
   @FXML
    private TextField txt_no;
    @FXML
    private TextField txt_adi;
    @FXML
    private TextField txt_sadi;
    @FXML
    private ChoiceBox<String> cmb_bolum;
    @FXML
    private TextField txt_adres;
    @FXML
    private PieChart pie;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       BolumQueries bol=new BolumQueries();
       ObservableList<Bolum> liste=bol.bolumleriGetir();
       cmb_bolum.getItems().add("");
       for (int i = 0; i < liste.size(); i++) 
            cmb_bolum.getItems().add(liste.get(i).getBadi());
    }    

        
         
 @FXML
    private void yeni_click(ActionEvent event) {
        txt_no.setText("");
        txt_adi.setText("");
        txt_sadi.setText("");
        cmb_bolum.setValue("");
        txt_adres.setText("");
        txt_no.requestFocus();
    }

    @FXML
    private void kaydet_click(ActionEvent event) {
       OgrenciQueries ogre=new OgrenciQueries();
       BolumQueries bol=new BolumQueries();
       int numara=bol.idGetir(cmb_bolum.getValue());
       Ogrenci ogr=new Ogrenci(txt_no.getText(), txt_adi.getText(), txt_sadi.getText(), 
               txt_adres.getText(), numara);
       ogre.ogrenciKayit(ogr);
    }

    @FXML
    private void degistir_click(ActionEvent event) {
       OgrenciQueries ogre=new OgrenciQueries();
       BolumQueries bol=new BolumQueries();
       int numara=bol.idGetir(cmb_bolum.getValue());
       Ogrenci ogr=new Ogrenci(txt_no.getText(), txt_adi.getText(), txt_sadi.getText(), 
               txt_adres.getText(), numara);
       ogre.ogrenciDegistir(ogr);
    }

    @FXML
    private void sil_click(ActionEvent event) {
        if(JOptionPane.showConfirmDialog(null, "Silmek İstediğinize emin misiniz?", 
                "Dikkat", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            OgrenciQueries ogre=new OgrenciQueries();
            ogre.ogrenciSil(txt_no.getText());
            yeni_click(event);
        }
    }

    @FXML
    private void ara_click(ActionEvent event) {
        OgrenciQueries ogre=new OgrenciQueries();
        Ogrenci sonuc=ogre.ogrenciBul(txt_no.getText());
        if(sonuc!=null){
            BolumQueries bol=new BolumQueries();
            String bisim=bol.isimGetir(sonuc.getBID());
            txt_adi.setText(sonuc.getOgrAdi());
            txt_sadi.setText(sonuc.getOgrSadi());
            txt_adres.setText(sonuc.getOgrAdres());
            cmb_bolum.setValue(bisim);
        }
        else
            JOptionPane.showMessageDialog(null,"Kayıt Bulunamadı");
    }

    @FXML
    private void ciz_click(ActionEvent event) {
        DersQueries rp=new DersQueries();
        List<Ders> liste=rp.dersRapor();
        ObservableList<PieChart.Data> grafikData = FXCollections.observableArrayList();
        for(int i=0;i<liste.size();i++)
            grafikData.add(new PieChart.Data(liste.get(i).getDKodu(), liste.get(i).getSayi()));
        
        pie.setData(grafikData);
        pie.setLegendVisible(true);
        pie.setLegendSide(Side.TOP);
        pie.setTitle("Ders Dağılımları");
            
    }
    
}
