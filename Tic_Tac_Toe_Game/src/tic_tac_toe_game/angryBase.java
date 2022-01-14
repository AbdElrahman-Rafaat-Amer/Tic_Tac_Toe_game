package tic_tac_toe_game;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class angryBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final Button okbutton;

    public angryBase( Stage stage) {

        anchorPane = new AnchorPane();
        text = new Text();
        okbutton = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(608.0);

        text.setLayoutX(118.0);
        text.setLayoutY(122.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("You must Choose X or O");
        text.setWrappingWidth(372.154296875);
        text.setFont(new Font(34.0));

        okbutton.setLayoutX(226.0);
        okbutton.setLayoutY(220.0);
        okbutton.setMnemonicParsing(false);
        okbutton.setPrefHeight(25.0);
        okbutton.setPrefWidth(142.0);
        okbutton.setText("Ok");
        okbutton.setTextFill(javafx.scene.paint.Color.valueOf("#1e1d1d"));
        okbutton.setFont(new Font(18.0));

        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(okbutton);
        getChildren().add(anchorPane);
       
        anchorPane.getStylesheets().add("/CssStyles/CssStyles.css");
        anchorPane.getStyleClass().add("angry");
     
        okbutton.setOnAction((Action) -> {
                Parent root2 = new XorOSelection(stage);
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();
        });        
        
        
        
        
        
       
    }
}
