package tic_tac_toe_game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
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

public class FXMLSignIn extends AnchorPane {

    protected final Pane pane1SingIN;
    protected final Pane pane2SignIn;
    protected final Text textSignIn;
    protected final TextField emailSignIn;
    protected final TextField passwordSIgnIn;
    protected final Button buttonConSingIn;
    protected final Button backButton;
    private Stage stage;
    private String realReply = "";
    private String email, password;
    static String playerName;
    static String playerScore;
    Start start;
    DataInputStream dataInputStream;
    PrintStream printStream;
    Thread thread;

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

        try {
            printStream = new PrintStream(Start.server.getOutputStream());
            dataInputStream = new DataInputStream(Start.server.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(FXMLSignUpp.class.getName()).log(Level.SEVERE, null, ex);
        }

        reciveData();
        /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String reply = dataInputStream.readLine();
                        System.out.println("Reply >>>>>>>>> " + reply);
                        realReply = reply;
                        System.out.println("realReply >>>>>>>>> " + realReply);
                         Platform.runLater(() -> {
                            if (realReply.equals("true")) {
                                Platform.runLater(() -> {
                                    RequestPage.email = email;
                                    Parent root2 = new RequestPage(stage);
                                    Scene scene2 = new Scene(root2);
                                    stage.setScene(scene2);
                                    stage.show();
                                });
                            } else {
                                Platform.runLater(() -> {
                                    new Alert(Alert.AlertType.ERROR, "Password or email is wrong\n" + realReply).show();
                                });
                            }
                        });
                    } catch (IOException ex) {
                        closeTheConnection();
                        Platform.exit();
                        System.exit(0);
                        new Alert(Alert.AlertType.ERROR, "Error in recieve Data\n" + ex.getMessage()).show();
                        System.out.println("-------------------------------Error in recieve Data-------------------------------");
                        // Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();*/
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

        buttonConSingIn.setLayoutX(310.0);
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
                String msg = email + ":" + password;
                printStream.println(msg);
                System.out.println("msg >>>>>>>>>>>>>>>>>>>>>> " + msg);
                System.out.println("Reply ============befotr==============" + realReply);
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
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String reply = dataInputStream.readLine();
                        System.out.println("Reply >>>>>>>>> " + reply);
                        realReply = reply;
                        System.out.println("realReply >>>>>>>>> " + realReply);
                        Platform.runLater(() -> {
                            if (!realReply.equals("false")) {
                                Platform.runLater(() -> {
                                    divideReply(realReply);
                                    RequestPage.email = email;
                                    Parent root2 = new RequestPage(stage);
                                    Scene scene2 = new Scene(root2);
                                    stage.setScene(scene2);
                                     thread.stop();
                                    stage.show();
                                });
                            } else {
                                //Platform.runLater(() -> {
                                new Alert(Alert.AlertType.ERROR, "Password or email is wrong\n" + realReply).show();
                                //});
                            }
                        });
                    } catch (IOException ex) {
                        closeTheConnection();
                        Platform.exit();
                        System.exit(0);
                        new Alert(Alert.AlertType.ERROR, "Error in recieve Data\n" + ex.getMessage()).show();
                        System.out.println("-------------------------------Error in recieve Data-------------------------------");
                        // Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }

    public void closeTheConnection() {

        try {
            printStream.close();
            dataInputStream.close();
            Start.server.close();
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "Error in close Connection\n" + ex.getMessage()).show();
        }

    }

    public void divideReply(String reply) {

        StringTokenizer stringTokenizer = new StringTokenizer(reply, " ");

        /*while (stringTokenizer.hasMoreTokens()) {
            
            
        }*/
        String replString = stringTokenizer.nextToken();
        playerName = stringTokenizer.nextToken();
        playerScore = stringTokenizer.nextToken();

        System.out.println(replString + "\t\t\t" + playerName + "\t\t\t" + playerScore + "\t\t\t");
    }
}
