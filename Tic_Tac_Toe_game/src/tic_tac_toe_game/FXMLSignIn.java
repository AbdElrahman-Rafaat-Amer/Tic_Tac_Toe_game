package tic_tac_toe_game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONObject;

public class FXMLSignIn extends AnchorPane {

    protected final Pane pane1SingIN;
    protected final Pane pane2SignIn;
    protected final Text textSignIn;
    protected final TextField emailSignIn;
    protected final TextField passwordSIgnIn;
    protected final Button buttonConSingIn;
    protected final Button backButton;
    private Stage stage;
    private String email, password;
    static String playerName;
    static int playerScore;
    Start start;
    Thread thread;
    boolean r;
    static JSONObject players;

    public FXMLSignIn(Stage stage) {
        this.stage = stage;
        pane1SingIN = new Pane();
        pane2SignIn = new Pane();
        textSignIn = new Text();
        emailSignIn = new TextField();
        passwordSIgnIn = new TextField();
        buttonConSingIn = new Button();
        backButton = new Button();
        start = new Start(stage);

        getStylesheets().add("/CssStyles/CssStyles.css");
        getStyleClass().add("gameimage");
        
        backButton.getStylesheets().add("/CssStyles/CssStyles.css");
        backButton.getStyleClass().add("btnback");
        
        textSignIn.getStyleClass().add("tittle");
        
        buttonConSingIn.getStylesheets().add("/CssStyles/CssStyles.css");
        buttonConSingIn.getStyleClass().add("btn");
        //recieving data in signup page..
        reciveData();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        pane1SingIN.setPrefHeight(400.0);
        pane1SingIN.setPrefWidth(600.0);

        pane2SignIn.setPrefHeight(400.0);
        pane2SignIn.setPrefWidth(600.0);

        textSignIn.setLayoutX(191.0);
        textSignIn.setLayoutY(66.0);
        textSignIn.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textSignIn.setStrokeWidth(0.0);
        textSignIn.setText("SIGN IN ");
        textSignIn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textSignIn.setWrappingWidth(190.90185546875);

        emailSignIn.setLayoutX(164.0);
        emailSignIn.setLayoutY(115.0);
        emailSignIn.setPrefHeight(31.0);
        emailSignIn.setPrefWidth(244.0);
        emailSignIn.setPromptText("EMAIL");

        passwordSIgnIn.setLayoutX(164.0);
        passwordSIgnIn.setLayoutY(185.0);
        passwordSIgnIn.setPrefHeight(31.0);
        passwordSIgnIn.setPrefWidth(244.0);
        passwordSIgnIn.setPromptText("PASSWORD");

        buttonConSingIn.setLayoutX(191.0);
        buttonConSingIn.setLayoutY(258.0);
        buttonConSingIn.setMnemonicParsing(false);
        buttonConSingIn.setPrefHeight(31.0);
        buttonConSingIn.setPrefWidth(91.0);
        buttonConSingIn.setText("CONFIRM");
        buttonConSingIn.setOnAction((event) -> {
            email = emailSignIn.getText().trim();
            password = passwordSIgnIn.getText().trim();
            System.out.println("email = " + email + "\t\tPassword = " + password);
            if (!email.isEmpty() && !password.isEmpty()) {

                JSONObject jSObject = new JSONObject();
                jSObject.put("key", "login");
                jSObject.put("email", email);
                jSObject.put("password", password);
                String msg = jSObject.toString();
                Start.printStream.println(msg);
                System.out.println("Reply ============befotr==============" + msg);
            } else {
                new Alert(Alert.AlertType.ERROR, "email or passwprd can not be empty").show();
            }
        });
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");

        pane2SignIn.getChildren().add(textSignIn);
        pane2SignIn.getChildren().add(emailSignIn);
        pane2SignIn.getChildren().add(passwordSIgnIn);
        pane2SignIn.getChildren().add(buttonConSingIn);
        pane2SignIn.getChildren().add(backButton);
        pane1SingIN.getChildren().add(pane2SignIn);
        getChildren().add(pane1SingIN);

        backButton.setOnAction(
                (Action) -> {
                    Parent root2 = new FXMLSelection(stage);
                    Scene scene2 = new Scene(root2);
                    stage.setScene(scene2);
                    stage.show();
                }
        );
    }

    void reciveData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String reply = Start.dataInputStream.readLine();
                        JSONObject object = new JSONObject(reply);
                        r = object.getBoolean("login");

                        System.out.println("Reply >>>>>>>>> " + reply);
                        Platform.runLater(() -> {
                            if (r) {
                                Platform.runLater(() -> {
                                    String returnPlayers;
                                    try {
                                        //from the first message "reply"
                                        playerName = object.getString("username");
                                        playerScore = object.getInt("score");
                                        returnPlayers = Start.dataInputStream.readLine();
                                        System.out.println("return players :" + returnPlayers);
                                        players = new JSONObject(returnPlayers);
                                        RequestPage.email = email;
                                        Parent root2 = new RequestPage(stage);
                                        Scene scene2 = new Scene(root2);
                                        stage.setScene(scene2);
                                        stage.show();
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            } else {
                                Platform.runLater(() -> {
                                    new Alert(Alert.AlertType.ERROR, "Password or email is wrong\n").show();
                                });
                            }
                        });
                    } catch (IOException ex) {
                        try {
                            Start.server.close();
                            Start.printStream.close();
                            Start.dataInputStream.close();
                        } catch (IOException ex1) {
                            Logger.getLogger(RequestPage.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        Platform.runLater(() -> {
                            new Alert(Alert.AlertType.INFORMATION, "There are problem in connection\n you can play offline\n" + ex.getMessage()).show();
                        });
                        System.out.println("-------------------------------SignIn in Error in recieve Data-------------------------------");
                        break;

                    }
                    if (r) {
                        break;
                    }

                }
            }
        }).start();
    }
}
