package tic_tac_toe_game;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.nashorn.api.scripting.JSObject;

public class ResualtSceneLoser extends AnchorPane {
    
    protected final VBox vBox;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final MediaView mediaView;
    protected final AnchorPane anchorPane0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final Button button;
    protected final Button button0;
    protected final VBox vBox0;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    protected static String loser;

    public ResualtSceneLoser(Stage stage) {

        this.stage = stage;
        vBox = new VBox();
        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        text = new Text();
        mediaView = new MediaView();
        anchorPane0 = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        button = new Button();
        button0 = new Button();
        vBox0 = new VBox();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(710.0);
        setPrefWidth(653.0);

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(600.0);
        vBox.setPrefWidth(600.0);
        vBox.getStyleClass().add("im");
        vBox.getStylesheets().add("/tic_tac_toe_game/../bgStyle.css");

        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        borderPane.setPrefHeight(600.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setMaxHeight(USE_PREF_SIZE);
        anchorPane.setMaxWidth(USE_PREF_SIZE);
        anchorPane.setMinHeight(USE_PREF_SIZE);
        anchorPane.setMinWidth(USE_PREF_SIZE);
        anchorPane.setPrefHeight(551.0);
        anchorPane.setPrefWidth(654.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#fdfdfd"));
        text.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
        text.setLayoutX(184.0);
        text.setLayoutY(109.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("You Lose");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setFont(new Font("Berlin Sans FB Demi Bold", 79.0));

        mediaView.setFitHeight(400.0);
        mediaView.setFitWidth(400.0);
        mediaView.setLayoutX(127.0);
        mediaView.setLayoutY(137.0);
        borderPane.setCenter(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(324.0);
        anchorPane0.setPrefWidth(654.0);

        AnchorPane.setLeftAnchor(gridPane, 111.0);
        AnchorPane.setRightAnchor(gridPane, 89.0);
        gridPane.setLayoutX(111.0);
        gridPane.setLayoutY(24.0);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(62.0);
        gridPane.setPrefWidth(343.0);

        columnConstraints.setFillWidth(false);
        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setFillWidth(false);
        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setFillWidth(false);
        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button.setMnemonicParsing(false);
        button.setPrefHeight(62.0);
        button.setPrefWidth(149.0);
        button.setText("Back to menu");

        GridPane.setColumnIndex(button0, 2);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(61.0);
        button0.setPrefWidth(148.0);
        button0.setText("Rematch");
        borderPane.setBottom(anchorPane0);

        vBox0.setLayoutX(10.0);
        vBox0.setLayoutY(10.0);

        getChildren().add(vBox);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(mediaView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        anchorPane0.getChildren().add(gridPane);
        getChildren().add(borderPane);
        getChildren().add(vBox0);

    }
}
