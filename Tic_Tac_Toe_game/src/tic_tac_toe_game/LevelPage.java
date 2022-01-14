package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LevelPage extends BorderPane {

    protected final FlowPane flowPane;
    protected final Text text;
    protected final Button easyButton;
    protected final Button mediumButton;
    protected final Button hardButton;
    protected final Button backButton;
    protected static String level;

    public LevelPage(Stage stage) {

        flowPane = new FlowPane();
        text = new Text();
        easyButton = new Button();
        mediumButton = new Button();
        hardButton = new Button();
        backButton = new Button();

        easyButton.getStylesheets().add("/CssStyles/CssStyles.css");
        easyButton.getStyleClass().add("btn");
        
        mediumButton.getStylesheets().add("/CssStyles/CssStyles.css");
        mediumButton.getStyleClass().add("btn");
        
        hardButton.getStylesheets().add("/CssStyles/CssStyles.css");
        hardButton.getStyleClass().add("btn");
        
        backButton.getStylesheets().add("/CssStyles/CssStyles.css");
        backButton.getStyleClass().add("btnback");
        
        //text.getStylesheets().add("/CssStyles/CssStyles.css");
        text.getStyleClass().add("btnback");
        
        
        getStyleClass().add("image");
        getStylesheets().add("/CssStyles/CssStyles.css");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        easyButton.setAlignment(javafx.geometry.Pos.CENTER);
        easyButton.setLayoutX(200.0);
        easyButton.setLayoutY(100.0);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(38.0);
        easyButton.setPrefWidth(96.0);
        easyButton.setText("Easy");

        mediumButton.setAlignment(javafx.geometry.Pos.CENTER);
        mediumButton.setLayoutX(200.0);
        mediumButton.setLayoutY(200.0);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setPrefHeight(38.0);
        mediumButton.setPrefWidth(96.0);
        mediumButton.setText("Medium");

        hardButton.setAlignment(javafx.geometry.Pos.CENTER);
        hardButton.setLayoutX(200.0);
        hardButton.setLayoutY(300.0);
        hardButton.setMnemonicParsing(false);
        hardButton.setPrefHeight(38.0);
        hardButton.setPrefWidth(96.0);
        hardButton.setText("Hard");

        text.setLayoutX(225.0);
        text.setLayoutY(85.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Choose Level ");
        text.setWrappingWidth(199.13671875);
        text.setFont(new Font(21.0));

        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(25.0);
        backButton.setPrefWidth(66.0);
        backButton.setText("Back");

        getChildren().add(easyButton);
        getChildren().add(mediumButton);
        getChildren().add(hardButton);
        getChildren().add(text);
        getChildren().add(backButton);
        easyButton.setOnAction((Action) -> {
            level = "easy";
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        mediumButton.setOnAction((Action) -> {
            level = "medium";
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        hardButton.setOnAction((Action) -> {
            level = "hard";
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        backButton.setOnAction((Action) -> {
            Parent root2 = new SelectPlayersNo(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
    }
}
