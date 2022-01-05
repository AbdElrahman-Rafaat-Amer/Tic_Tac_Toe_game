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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Start extends Pane {

    protected final Button online;
    protected final Button offline;
    protected final Button exit;
    private Stage mystage;
    static String IPAdress;
    private TextInputDialog ipDialog;
    private boolean isRight = false;
    private String message = "Enter your Ip Address to play online";
    static Socket server;
    static DataInputStream dataInputStream;
    static PrintStream printStream;

    public Start(Stage stage) {
        mystage = stage;
        online = new Button();
        offline = new Button();
        exit = new Button();
        ipDialog = new TextInputDialog();

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
        ipDialog.setHeaderText(message);

        Button button = (Button) ipDialog.getDialogPane().lookupButton(ButtonType.OK);

        button.setOnAction((ActionEvent event) -> {
            IPAdress = ipDialog.getEditor().getText();
            isRight = checkIPAddress(IPAdress);
            if (isRight) {
                //Ip right
                System.err.println("okButton");
                try{
            server = new Socket(IPAdress,5005);
            printStream = new PrintStream(server.getOutputStream());
            dataInputStream = new DataInputStream(server.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                Parent root2 = new FXMLSelection(stage);
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();
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
