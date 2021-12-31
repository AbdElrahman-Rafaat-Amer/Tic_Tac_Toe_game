package tic_tac_toe_game;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLSelection extends AnchorPane {

    protected final Pane Pane1Selc;
    protected final Pane Pane2Selec;
    protected final Button signInButton;
    protected final Button signUpButton;
    protected final Text text;

    public FXMLSelection(Stage stage) {

        Pane1Selc = new Pane();
        Pane2Selec = new Pane();
        signInButton = new Button();
        signUpButton = new Button();
        text = new Text();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        Pane1Selc.setPrefHeight(400.0);
        Pane1Selc.setPrefWidth(600.0);

        Pane2Selec.setPrefHeight(400.0);
        Pane2Selec.setPrefWidth(600.0);

        signInButton.setLayoutX(270.0);
        signInButton.setLayoutY(115.0);
        signInButton.setMnemonicParsing(false);
        signInButton.setText("SIGN IN");

        signUpButton.setLayoutX(268.0);
        signUpButton.setLayoutY(169.0);
        signUpButton.setMnemonicParsing(false);
        signUpButton.setText("SIGN UP");

        text.setLayoutX(258.0);
        text.setLayoutY(57.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("CHOOSE");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(95.41552734375);

        Pane2Selec.getChildren().add(signInButton);
        Pane2Selec.getChildren().add(signUpButton);
        Pane2Selec.getChildren().add(text);
        Pane1Selc.getChildren().add(Pane2Selec);
        getChildren().add(Pane1Selc);

        signUpButton.setOnAction((Action)->{
            Parent root2 = new FXMLSingUpp(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
        signInButton.setOnAction((Action)->{
            Parent root2 = new FXMLSignIn(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
    }
}
