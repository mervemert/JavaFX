/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.LoginQueries;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author merve.mert
 */
public class LoginController implements Initializable{
    
    @FXML
    private TextField txt_girisEposta;
    @FXML
    private TextField txt_girisPassword;
    @FXML
    private Button btn_login;
    
    
    @FXML
    private void loginClick(ActionEvent event){
        LoginQueries loginQueries = new LoginQueries();
        try {
            if(loginQueries.login(txt_girisEposta.getText(), txt_girisPassword.getText())){             
                JOptionPane.showMessageDialog(null, "E-posta ve şifre doğru, Sisteme başarıyla giriş yaptınız");                        
            } else {              
                 JOptionPane.showMessageDialog(null, "E-posta veya şifre hatalı");               
            }
                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //todo
    }
    
    
    
}
