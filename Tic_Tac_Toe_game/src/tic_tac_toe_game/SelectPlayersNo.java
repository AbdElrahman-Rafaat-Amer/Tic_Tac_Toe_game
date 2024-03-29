package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectPlayersNo extends AnchorPane {

    protected final Button oneplayer;
    protected final Button twoplayer;
    protected final Button backButton;
    private Stage mystage;
    static boolean isSingle;

    public SelectPlayersNo(Stage stage) {

        System.err.println("in SelectPlayersNo");
        oneplayer = new Button();
        twoplayer = new Button();
        backButton = new Button();
 //CSS 
         
        oneplayer.getStylesheets().add("/CssStyles/CssStyles.css");
        oneplayer.getStyleClass().add("btn");
        
        twoplayer.getStylesheets().add("/CssStyles/CssStyles.css");
        twoplayer.getStyleClass().add("btn");
        
        backButton.getStylesheets().add("/CssStyles/CssStyles.css");
        backButton.getStyleClass().add("btnback");
        
        getStyleClass().add("image");
        getStylesheets().add("/CssStyles/CssStyles.css");


        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        oneplayer.setLayoutX(200.0);
        oneplayer.setLayoutY(100.0);
        oneplayer.setMnemonicParsing(false);
        oneplayer.setPrefHeight(38.0);
        oneplayer.setPrefWidth(96.0);
        oneplayer.setText("One Player");

        twoplayer.setLayoutX(200.0);
        twoplayer.setLayoutY(190.0);
        twoplayer.setMnemonicParsing(false);
        twoplayer.setPrefHeight(38.0);
        twoplayer.setPrefWidth(96.0);
        twoplayer.setText("Two Player");

        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(25.0);
        backButton.setPrefWidth(60.0);
        backButton.setText("Back");

        getChildren().add(oneplayer);
        getChildren().add(twoplayer);
        getChildren().add(backButton);
        oneplayer.setOnAction((Action) -> {
            isSingle = true;
            Parent root2 = new LevelPage(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        //button ytl3 3la select x or o
        twoplayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isSingle = false;
                Parent root = new XorOSelection(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
        //button back
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new Start(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}
