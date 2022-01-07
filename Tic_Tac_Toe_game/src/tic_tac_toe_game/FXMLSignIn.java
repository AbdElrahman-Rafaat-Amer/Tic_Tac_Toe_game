package tic_tac_toe_game;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
    private String reply;
    private String email, password;

    public FXMLSignIn(Stage stage) {
        this.stage = stage;
        pane1SingIN = new Pane();
        pane2SignIn = new Pane();
        textSignIn = new Text();
        emailSignIn = new TextField();
        passwordSIgnIn = new TextField();
        buttonConSingIn = new Button();
        backButton = new Button();

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
        buttonConSingIn.setOnAction((ActionEvent event) -> {
            String email = emailSignIn.getText().trim();
            String password = passwordSIgnIn.getText().trim();
            //try {
            if (email.matches("[\\S]+{1,}") && password.matches("[\\S]+{1,}")) {
                //  Platform.runLater(() -> {
                //    checkLogin(email, password);
                // });

                try {
                    String msg = email + ":" + password;
                    Start.printStream.println(msg);
                    String reply = Start.dataInputStream.readLine();
                    if (reply.equals("true")) {
                        Platform.runLater(() -> {
                            RequestPage.email = email;
                            Parent root2 = new RequestPage(stage);
                            Scene scene2 = new Scene(root2);
                            stage.setScene(scene2);
                            stage.show();
                        });

                    } else {
                        Platform.runLater(() -> {
                            new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
                        });
                    }
                } catch (IOException ex) {
                    new Alert(Alert.AlertType.ERROR, "there are problem in connection").show();
                    //Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "email or passwprd can not be empty").show();
            }
        } //catch (SQLException ex) {}}
        );
        /* buttonConSingIn.setOnAction((ActionEvent event) -> {
            email = emailSignIn.getText().trim();
            password = passwordSIgnIn.getText().trim();
            //try {
            if (email.matches("[\\S]+{1,}") && password.matches("[\\S]+{1,}")) {
                //  Platform.runLater(() -> {
                //    checkLogin(email, password);
                // });
                String msg = email + ":" + password;
                Start.printStream.println(msg);
                System.err.println("reply in button >>>>>>>>>>>>>>>>>>>>>" + reply);

                if (reply.equals("true")) {
                    Platform.runLater(() -> {
                        RequestPage.email = email;
                        Parent root2 = new RequestPage(stage);
                        Scene scene2 = new Scene(root2);
                        stage.setScene(scene2);
                        stage.show();
                    });
                } else {
                    Platform.runLater(() -> {
                        new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
                    });

                }
            } else {
                Platform.runLater(() -> {
                    new Alert(Alert.AlertType.ERROR, "email or passwprd can not be empty").show();
                });

            }
        });
        Platform.runLater(() -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            reply = Start.dataInputStream.readLine();
                            /* if (reply.equals("true")) {
                                RequestPage.email = email;
                                Parent root2 = new RequestPage(stage);
                                Scene scene2 = new Scene(root2);
                                stage.setScene(scene2);
                                stage.show();
                            } else {
                                Platform.runLater(() -> {
                                    new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
                                });
                            }
                        } catch (IOException ex) {
                            new Alert(Alert.AlertType.ERROR, "there are problem in connection").show();
                        }
                    }
                }
            }).start();
        });*/
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
    /*
    void checkLogin(String email, String password) {
        
        //while (true) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = email + ":" + password;
                    Start.printStream.println(msg);
                    final String reply = Start.dataInputStream.readLine();
                    setReply(reply);
                } catch (IOException ex) {
                    new Alert(Alert.AlertType.ERROR, "there are problem in connection").show();
                    //Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
               
        if (!reply.equals("") && !reply.isEmpty() && reply.equals("true")) {
            RequestPage.email = email;
            Parent root2 = new RequestPage(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
        }

        //}
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = email + ":" + password;
                        Start.printStream.println(msg);
                        String reply = Start.dataInputStream.readLine();
                        if (reply.equals("true")) {
                            RequestPage.email = email;
                            Parent root2 = new RequestPage(stage);
                            Scene scene2 = new Scene(root2);
                            stage.setScene(scene2);
                            stage.show();
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
                        }
                    } catch (IOException ex) {
                        new Alert(Alert.AlertType.ERROR, "there are problem in connection").show();
                        //Logger.getLogger(FXMLSignIn.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }).start();
 /* }

    void setReply(String re) {
       reply = re;
        
    }*/
}
