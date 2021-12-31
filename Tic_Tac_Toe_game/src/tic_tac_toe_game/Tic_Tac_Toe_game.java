/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe_game;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tic_Tac_Toe_game extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLSelection(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void stop()
    {
        Player.con.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}

