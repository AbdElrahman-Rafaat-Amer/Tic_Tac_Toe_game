package gamexo;

import com.sun.org.apache.bcel.internal.generic.INEG;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//import javafx.scene.gamexo.FXMLDocumentBase2;
public  class FXMLDocumentBase1 extends Pane {
   

    protected final Button online;
    protected final Button offline;
    protected final Button exit;

    private Stage mystage;
    
        
    public FXMLDocumentBase1( Stage stage) {
          mystage = stage;
        online = new Button();
        offline = new Button();
        exit = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        online.setLayoutX(230.0);
        online.setLayoutY(132.0);
        online.setMnemonicParsing(false);
        online.setPrefHeight(38.0);
        online.setPrefWidth(96.0);
        online.setText("Online");

        offline.setLayoutX(230.0);
        offline.setLayoutY(170.0);
        offline.setMnemonicParsing(false);
        offline.setPrefHeight(38.0);
        offline.setPrefWidth(96.0);
        offline.setText("Offline");

        exit.setLayoutX(230.0);
        exit.setLayoutY(208.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(38.0);
        exit.setPrefWidth(96.0);
        exit.setText("Exit");

        getChildren().add(online);
        getChildren().add(offline);
        getChildren().add(exit);
        //button offline hytl3 3la 2 players
         offline.setOnAction((Action) -> {
           Parent root2 = new FXMLDocumentBase2(stage);
          Scene scene2 = new Scene(root2);
          stage.setScene(scene2);
          stage.show();  
        });
      /* offline.setOnAction(new EventHandler<ActionEvent>() {
            @Override
        public void handle(ActionEvent event) {
          Parent root2 = new FXMLDocumentBase2(stage);
          Scene scene2 = new Scene(root2);
          stage.setScene(scene2);
          stage.show();   
         }
        });*/
}
}
