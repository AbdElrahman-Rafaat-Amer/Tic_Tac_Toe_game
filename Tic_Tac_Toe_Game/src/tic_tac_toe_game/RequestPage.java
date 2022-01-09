package tic_tac_toe_game;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RequestPage extends BorderPane {

    protected final FlowPane flowPane;
    protected final Label playerNameLabel;
    protected final Label scoreLabel;
    protected final Button historyButton;
    protected final Button homeButton;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final ListView listRequests;
    protected final ListView listAvailablePlayers;
    private final Stage stage;
    private MediaPlayer mediaPlayer;
    private Scene currentScene;
    protected static String email;
    MediaView mediaView;
    String name = "Player", score = "score";

    public RequestPage(Stage stage) {

        this.stage = stage;
        flowPane = new FlowPane();
        playerNameLabel = new Label();
        scoreLabel = new Label();
        historyButton = new Button();
        homeButton = new Button();
        anchorPane = new AnchorPane();
        label = new Label();
        listRequests = new ListView();
        listAvailablePlayers = new ListView();
        name = FXMLSignIn.playerName;
        score = FXMLSignIn.playerScore;

        playerNameLabel.setText(name);
        scoreLabel.setText(score);
        ObservableList<String> sendList = FXCollections.observableArrayList("Player1", "Player2", "Player3", "Player4", "Player5", "Player6");
        listRequests.setItems(sendList);

        listRequests.setCellFactory((Callback<ListView<String>, ListCell<String>>) param -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        HBox root = new HBox(10);
                        root.setAlignment(Pos.CENTER_LEFT);
                        root.setPadding(new Insets(5, 10, 5, 10));
                        root.getChildren().add(new Label(item));
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        root.getChildren().add(region);

                        Button sendRequest = new Button("Send");
                        sendRequest.setOnAction(event -> {
                            // Code to send invite   

                            //then play vedio until response
                            File mediaFile = new File("src\\vedios_media\\waiting vedio.mp4");
                            Media media = new Media(mediaFile.toURI().toString());
                            mediaPlayer = new MediaPlayer(media);
                            mediaView = new MediaView(mediaPlayer);

                            mediaPlayer.setAutoPlay(true);
                            Group root2 = new Group();
                            root2.getChildren().add(mediaView);
                            currentScene = stage.getScene();
                            Scene scene = new Scene(root2, 600, 600);
                            stage.setScene(scene);
                            stage.setTitle("Playing video");
                            mediaView.setFitHeight(600);
                            mediaView.setFitWidth(600);
                            System.out.println(scene.getHeight());
                            System.out.println(scene.getWidth());
                            stage.show();
                            sendRequest.setDisable(true);

                            //if there is no response the vedio will play to the end
                            mediaPlayer.setOnEndOfMedia(new Runnable() {
                                @Override
                                public void run() {
                                    stage.setScene(currentScene);
                                }
                            });

                            //if there is  response by accept the invite will end the vedio and go to play
                            //go to game online
                            //if there is  response by refus the invite will end the vedio and go back to the current page to send another request 
                        });

                        root.getChildren().addAll(sendRequest);
                        setGraphic(root);
                    }
                }
            };
        });

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(519.0);
        setPrefWidth(741.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.TOP_RIGHT);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(51.0);
        flowPane.setPrefWidth(741.0);

        playerNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        playerNameLabel.setPrefHeight(51.0);
        playerNameLabel.setPrefWidth(144.0);
        // the name will change according to the player name when he will login or signup
        playerNameLabel.setText(name);

        scoreLabel.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel.setPrefHeight(47.0);
        scoreLabel.setPrefWidth(166.0);
        // the name will bring the score according to the player from database
        scoreLabel.setText(score);

        FlowPane.setMargin(scoreLabel, new Insets(0.0, 0.0, 0.0, 50.0));

        historyButton.setAlignment(javafx.geometry.Pos.CENTER);
        historyButton.setMnemonicParsing(false);
        historyButton.setPrefHeight(45.0);
        historyButton.setPrefWidth(92.0);
        historyButton.setText("History");
        historyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Code will open the file contain recordes 
            }
        });

        FlowPane.setMargin(historyButton, new Insets(0.0, 0.0, 0.0, 50.0));

        homeButton.setAlignment(javafx.geometry.Pos.CENTER);
        homeButton.setMnemonicParsing(false);
        homeButton.setPrefHeight(45.0);
        homeButton.setPrefWidth(99.0);
        homeButton.setText("Home");
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Code will redirect you to the home page
                Parent root2 = new FXMLSelection(stage);
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();

            }
        });
        FlowPane.setMargin(homeButton, new Insets(0.0, 0.0, 0.0, 50.0));
        BorderPane.setMargin(flowPane, new Insets(0.0));
        flowPane.setPadding(new Insets(10.0));
        setTop(flowPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(254.0);
        label.setLayoutY(4.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(212.0);
        label.setText("Requests");

        listRequests.setLayoutY(25.0);
        listRequests.setPrefHeight(342.0);
        listRequests.setPrefWidth(741.0);

        listAvailablePlayers.setLayoutY(372.0);
        listAvailablePlayers.setPrefHeight(78.0);
        listAvailablePlayers.setPrefWidth(741.0);
        setCenter(anchorPane);

        flowPane.getChildren().add(playerNameLabel);
        flowPane.getChildren().add(scoreLabel);
        flowPane.getChildren().add(historyButton);
        flowPane.getChildren().add(homeButton);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(listRequests);
        anchorPane.getChildren().add(listAvailablePlayers);
    }

}
