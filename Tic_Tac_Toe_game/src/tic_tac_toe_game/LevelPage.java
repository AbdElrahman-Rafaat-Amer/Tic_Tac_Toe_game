package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LevelPage extends BorderPane {

    protected final FlowPane flowPane;
    protected final Text text;
    protected final Button easyButton;
    protected final Button mediumButton;
    protected final Button hardButton;
    protected final Button backButton;

    public LevelPage(Stage stage) {

        flowPane = new FlowPane();
        text = new Text();
        easyButton = new Button();
        mediumButton = new Button();
        hardButton = new Button();
        backButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(334.0);
        flowPane.setPrefWidth(600.0);

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Custom level");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        easyButton.setAlignment(javafx.geometry.Pos.CENTER);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(38.0);
        easyButton.setPrefWidth(96.0);
        easyButton.setText("Easy");

        mediumButton.setAlignment(javafx.geometry.Pos.CENTER);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setPrefHeight(38.0);
        mediumButton.setPrefWidth(96.0);
        mediumButton.setText("Medium");

        hardButton.setAlignment(javafx.geometry.Pos.CENTER);
        hardButton.setMnemonicParsing(false);
        hardButton.setPrefHeight(38.0);
        hardButton.setPrefWidth(95.0);
        hardButton.setText("Hard");
        setCenter(flowPane);

        BorderPane.setAlignment(backButton, javafx.geometry.Pos.TOP_LEFT);
        backButton.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");
        setTop(backButton);

        flowPane.getChildren().add(text);
        flowPane.getChildren().add(easyButton);
        flowPane.getChildren().add(mediumButton);
        flowPane.getChildren().add(hardButton);

        
        easyButton.setOnAction((Action)->{
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
        mediumButton.setOnAction((Action)->{
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
        hardButton.setOnAction((Action)->{
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
        backButton.setOnAction((Action)->{
            Parent root2 = new SelectPlayersNo(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
    } 
}
