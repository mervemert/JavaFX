/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author merve.mert
 */
public class FXMLDocumentController implements Initializable {
    
    
    Stage stageGiris= new Stage();
    Stage stageUyeOl = new Stage();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
    @FXML
    private void toGirisYap(ActionEvent event) throws IOException {
       
        Parent root2 = FXMLLoader.load(getClass().getResource("/view/giris.fxml"));
        Scene scene2 = new Scene(root2);
        stageGiris.setScene(scene2);
        stageGiris.show();
        
    }
    

     @FXML
    private void toUyeOl(ActionEvent event) throws IOException {
        
        Parent root3 = FXMLLoader.load(getClass().getResource("/view/uyeOl.fxml"));
        Scene scene3 = new Scene(root3);
        stageUyeOl.setScene(scene3);
        stageUyeOl.show();
        stageGiris.close();
    }

    
}
