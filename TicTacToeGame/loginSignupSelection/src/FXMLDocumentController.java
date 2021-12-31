/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsingselection;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ayaab
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private TextField UsernameInput;
    @FXML
    private TextField EmailInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private TextField confirmpassInput;
    @FXML
    private Button confirmButton;
    @FXML
    private Text signUpText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendToSignIn(ActionEvent event) {
       
    }
    
}
