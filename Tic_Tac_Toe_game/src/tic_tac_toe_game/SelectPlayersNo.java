package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public  class SelectPlayersNo extends AnchorPane {

    protected final Button oneplayer;
    protected final Button twoplayer;
     private Stage mystage;
    public SelectPlayersNo( Stage stage ) {
        mystage=stage;
        oneplayer = new Button();
        twoplayer = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        oneplayer.setLayoutX(236.0);
        oneplayer.setLayoutY(152.0);
        oneplayer.setMnemonicParsing(false);
        oneplayer.setPrefHeight(38.0);
        oneplayer.setPrefWidth(96.0);
        oneplayer.setText("One Player");

        twoplayer.setLayoutX(236.0);
        twoplayer.setLayoutY(190.0);
        twoplayer.setMnemonicParsing(false);
        twoplayer.setPrefHeight(38.0);
        twoplayer.setPrefWidth(96.0);
        twoplayer.setText("Two Player");
        getChildren().add(oneplayer);
        getChildren().add(twoplayer);
        
        
        oneplayer.setOnAction((Action)->{
            Parent root2 = new LevelPage(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
       //button ytl3 3la select x or o
        twoplayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
        public void handle(ActionEvent event) {
          Parent root = new XorOSelection(stage);
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();   
         }
        });   
    }

   
    
}
