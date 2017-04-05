/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.KullaniciQueries;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Kullanici;

/**
 *
 * @author merve.mert
 */
public class KullaniciController implements Initializable {
    
    @FXML
    private TextField txt_adi;
    @FXML
    private TextField txt_soyadi;
    @FXML
    private TextField txt_eposta;
    @FXML
    private TextField txt_sifre;
    @FXML
    private TextField txt_sifreTkr;
    @FXML
    private DatePicker date_picker;
    @FXML
    private Button btn_geri;
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    @FXML
    private void toGeri(ActionEvent event) throws IOException {
        Stage stageGiris= new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        Scene scene2 = new Scene(root2);
        stageGiris.setScene(scene2);
        stageGiris.show();
    }
   

    
    @FXML
    private void kaydetKullanici(ActionEvent event) throws IOException{
    
        try {
        
            Date date = Date.valueOf(date_picker.getValue());

            KullaniciQueries kullaniciQueries = new KullaniciQueries();
            Kullanici kullanici = new Kullanici(txt_adi.getText(), txt_soyadi.getText(),
                    txt_eposta.getText(), txt_sifre.getText(), txt_sifreTkr.getText(), date);
            kullaniciQueries.kullaniciKayit(kullanici);
            
            JOptionPane.showMessageDialog(null, "Kayıt işlemi başarılı, anasayfaya yönlendiriliyorsunuz");
            
            Stage stage3 = new Stage();
            Parent root3 = FXMLLoader.load(getClass().getResource("/view/giris.fxml"));
            Scene scene3 = new Scene(root3);
            stage3.setScene(scene3);
            stage3.show();
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
      
        
       
        
      
     
        
    }

   
    
    
    
}
