package tic_tac_toe_game;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Vector;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import org.json.JSONObject;

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
    String name = "Player";
    int  score = -1;
    JSONObject returnplayer;

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
        scoreLabel.setText(String.valueOf(score));
        Vector<String> player = new Vector<String>();
        System.out.println("player list: "+FXMLSignIn.players.getJSONArray("list"));
        for (int i =0 ; i< FXMLSignIn.players.getJSONArray("list").length() ; i++)
        {//String.valueOf(i)
            listRequests.getItems().add(FXMLSignIn.players.getJSONArray("list").get(i));
            System.out.println("list element :"+FXMLSignIn.players.getJSONArray("list").get(i));
        }
        
        //to continue checking for updates in list 
        new Thread(new Runnable(){
            public void run()
            {
                while(true)
                {
                    try {
                        String returnPlayers = Start.dataInputStream.readLine();
                        returnplayer = new JSONObject(returnPlayers);
                        System.out.println("player IN 1 : "+returnplayer);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    String key = returnplayer.getString("key");
                                    switch(key)
                                    {
                                        case "player list":
                                            listRequests.getItems().clear();
                                            for (int i =0 ; i< returnplayer.getJSONArray("list").length() ; i++)
                                            {
                                            listRequests.getItems().add(returnplayer.getJSONArray("list").get(i));
                                            }
                                            System.out.println("player IN : "+returnplayer.getJSONArray("list"));
                                            break;
                                        case "play with me, please":
                                            Alert request = new Alert(Alert.AlertType.CONFIRMATION,returnplayer.getString("player1 username").toString()+" requests to play with you");
                                            Optional<ButtonType> result = request.showAndWait();
                                            JSONObject replay = new JSONObject();
                                            replay.put("key", "replay");
                                            //if(!result.isPresent())
                                                // alert is exited, no button has been pressed.
                                            //else
                                            if(result.get() == ButtonType.OK)
                                            //oke button is pressed
                                            {
                                                replay.put("request replay", "true");
                                                replay.put("player1 NO", returnplayer.getString("player1 NO"));
                                                replay.put("player2 NO", returnplayer.getString("player2 NO"));
                                                Start.printStream.println(replay);
                                                //Parent root2 = new GameScene(stage);
                                                //Scene scene2 = new Scene(root2);
                                                //stage.setScene(scene2);
                                                //stage.show();
                                            }
                                            else
                                                if(result.get() == ButtonType.CANCEL)
                                                // cancel button is pressed
                                                {
                                                    replay.put("request replay", "false");
                                                    replay.put("player1 NO", returnplayer.getString("player1 NO"));
                                                    replay.put("player2 NO", returnplayer.getString("player2 NO"));
                                                    Start.printStream.println(replay);
                                                    //Parent root2 = new RequestPage(stage);
                                                    //Scene scene2 = new Scene(root2);
                                                    //stage.setScene(scene2);
                                                    //stage.show();
                                                }
                                            break;
                                            
                                        case "Request Response":
                                            String reply = returnplayer.getString("response");
                                            if(reply.compareTo("true")==0)
                                            {
                                                //Parent root3 = new GameScene(stage);
                                                //Scene scene3 = new Scene(root3);
                                                //stage.setScene(scene3);
                                                //stage.show();
                                            }
                                            else
                                            {
                                                //Parent root3 = new RequestPage(stage);
                                                //Scene scene3 = new Scene(root3);
                                                //stage.setScene(scene3);
                                                //stage.show();
                                            }
                                    }
                                }
                            });
                        //}
                    } catch (IOException ex) {
                        Logger.getLogger(RequestPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }}).start();
        

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
                            JSONObject js = new JSONObject();
                            js.put("key", "request key");
                            if(returnplayer == null)
                            {
                                for(int j=0; j<FXMLSignIn.players.getJSONArray("list").length();j++)
                                {
                                    System.out.println("list item :" + FXMLSignIn.players.getJSONArray("list").get(j));
                                    
                                    if(FXMLSignIn.players.getJSONArray("list").get(j) == item )
                                    {
                                        System.out.println("PLayer2 key:"+j);
                                        js.put("player2 key",String.valueOf(j));
                                    }
                                }
                                for(int j=0; j<FXMLSignIn.players.getJSONArray("list").length();j++)
                                {
                                    System.out.println("name: "+name);
                                    if(FXMLSignIn.players.getJSONArray("list").get(j).toString().compareTo(name)==0)
                                    {
                                        System.out.println("PLayer1 key:"+j);
                                        js.put("player1 key",String.valueOf(j));
                                    }
                                }
                            }
                            else
                            {
                                for(int j=0; j<returnplayer.getJSONArray("list").length();j++)
                                {
                                    System.out.println("list item :" + returnplayer.getJSONArray("list").get(j));
                                    if(returnplayer.getJSONArray("list").get(j) == item )
                                    {
                                        System.out.println("PLayer2 key:"+j);
                                        js.put("player2 key",String.valueOf(j));
                                    }
                                }
                                for(int j=0; j<returnplayer.getJSONArray("list").length();j++)
                                {
                                    if(returnplayer.getString(String.valueOf(j)).compareTo(name)==0)
                                    {
                                        System.out.println("PLayer1 key:"+j);
                                        js.put("player1 key",String.valueOf(j));
                                    }
                                }
                                
                            }
                            Start.printStream.println(js);
                            
                           // System.out.println(returnplayers.keySet().);
                           // System.out.println("key of name : "+ players.getString(item));
                            System.out.println("cell factory "+item);

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
        scoreLabel.setText(String.valueOf(score));

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
