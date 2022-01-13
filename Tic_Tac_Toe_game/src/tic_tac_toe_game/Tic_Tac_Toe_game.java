package tic_tac_toe_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tic_Tac_Toe_game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new Start(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe game");
        stage.setResizable(false);
        stage.show();
    }
    
    public void stop()
    {
        System.exit(0);
        Platform.exit();
    }



    public static void main(String[] args) {
        launch(args);
    }

}
