package tic_tac_toe_game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;

public class Start extends Pane {

    protected final Button online;
    protected final Button offline;
    protected final Button exit;
    protected final Pane pane1;

    private Stage mystage;
    static String IPAdress;
    private TextInputDialog ipDialog;
    private boolean isRight = false;
    private String message = "Enter your Ip Address to play online";
    static Socket server;
    public static DataInputStream dataInputStream;
    public static PrintStream printStream;

    //public Start() {
    //}
    public Start(Stage stage) {

        mystage = stage;
        online = new Button();
        offline = new Button();
        exit = new Button();
        ipDialog = new TextInputDialog();
        pane1 = new Pane();
        
       //css
        online.getStylesheets().add("/CssStyles/CssStyles.css");
        online.getStyleClass().add("btn");
        
        offline.getStylesheets().add("/CssStyles/CssStyles.css");
        offline.getStyleClass().add("btn");
        
        exit.getStylesheets().add("/CssStyles/CssStyles.css");
        exit.getStyleClass().add("btn");
        
       // pane1.getStylesheets().add("/img/page.jpg");
        //pane1.getStyleClass().add("image");
        
        getStylesheets().add("/CssStyles/CssStyles.css");
        getStyleClass().add("image");
        
        pane1.setPrefHeight(200.0);
        pane1.setPrefWidth(600.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        online.setLayoutX(200.0);
        online.setLayoutY(100.0);
        online.setMnemonicParsing(false);
        online.setPrefHeight(38.0);
        online.setPrefWidth(96.0);
        online.setText("Online");
    

        offline.setLayoutX(200.0);
        offline.setLayoutY(200.0);
        offline.setMnemonicParsing(false);
        offline.setPrefHeight(38.0);
        offline.setPrefWidth(96.0);
        offline.setText("Offline");

        exit.setLayoutX(200.0);
        exit.setLayoutY(300.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(38.0);
        exit.setPrefWidth(96.0);
        exit.setText("Exit");

        getChildren().add(online);
        getChildren().add(offline);
        getChildren().add(exit);
        ipDialog.setHeaderText(message);
        
        

        Button button = (Button) ipDialog.getDialogPane().lookupButton(ButtonType.OK);

        button.setOnAction((ActionEvent event) -> {
            IPAdress = ipDialog.getEditor().getText();
            isRight = checkIPAddress(IPAdress);
            if (isRight) {
                //Ip right
               // new Thread(() -> {
                    try {
                        server = new Socket(IPAdress, 5005);
                        printStream = new PrintStream(server.getOutputStream());
                        dataInputStream = new DataInputStream(server.getInputStream());
                        Parent root2 = new FXMLSelection(stage);
                        Scene scene2 = new Scene(root2);
                        stage.setScene(scene2);
                        
                        stage.show();
                    } catch (IOException ex) {
                        new Alert(Alert.AlertType.ERROR, "There are erro in connection to server\nPlease ensure the server is running\n" + ex.getMessage()).show();
                        System.out.println("in catch in start Page for try of assign socket and dataprint stream");
                        //Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                    }
              //  }).start();

            } else {
                //Error in IP Address
                message = "there is error in your IP Address";
                ipDialog.setHeaderText(message);
                ipDialog.show();

            }
        });

        //button offline hytl3 3la 2 players
        offline.setOnAction((Action) -> {
            Parent root2 = new SelectPlayersNo(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        online.setOnAction((Action) -> {
            ipDialog.show();
        });

        exit.setOnAction((event) -> {
            System.exit(0);
            Platform.exit();

        });
    }

    private boolean checkIPAddress(String ipAddress) {
        boolean resulat = false;
        if (ipAddress != null) {
            String IPPattern = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
            IPPattern = IPPattern + "\\." + IPPattern + "\\." + IPPattern + "\\." + IPPattern;
            Pattern pattern = Pattern.compile(IPPattern);
            Matcher matcher = pattern.matcher(ipAddress);
            if (matcher.matches()) {
                resulat = true;
            }
        }

        return resulat;
    }
}