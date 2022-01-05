/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class Server extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new Servertictactoe(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
    }
        @Override
    public void stop() {
        try {
            if (DAO.con != null) {
                DAO.con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
