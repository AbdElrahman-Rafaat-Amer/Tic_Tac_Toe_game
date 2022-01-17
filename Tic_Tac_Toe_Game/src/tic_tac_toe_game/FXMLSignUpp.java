package tic_tac_toe_game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.JSONObject;

public class FXMLSignUpp extends AnchorPane {

    protected final Pane pane1;
    protected final Pane pane2;
    protected final TextField UsernameInput;
    protected final TextField EmailInput;
    protected final TextField passwordInput;
    protected final TextField confirmpassInput;
    protected final Button confirmButton;
    protected final Button backButton;
    protected final Text textSignUp;
    Player player = new Player();
    protected static int id = 0;
    private boolean message;
    Thread thread;

    public FXMLSignUpp(Stage stage) {

        pane1 = new Pane();
        pane2 = new Pane();
        UsernameInput = new TextField();
        EmailInput = new TextField();
        passwordInput = new TextField();
        confirmpassInput = new TextField();
        confirmButton = new Button();
        backButton = new Button();
        textSignUp = new Text();
getStylesheets().add("/CssStyles/CssStyles.css");
        getStyleClass().add("gameimage");
        
        backButton.getStylesheets().add("/CssStyles/CssStyles.css");
        backButton.getStyleClass().add("btnback");
        
        textSignUp.getStyleClass().add("tittle");
        
        confirmButton.getStylesheets().add("/CssStyles/CssStyles.css");
        confirmButton.getStyleClass().add("btn");
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

       pane1.setLayoutY(1.0);
        pane1.setPrefHeight(400.0);
        pane1.setPrefWidth(600.0);

        pane2.setPrefHeight(401.0);
        pane2.setPrefWidth(600.0);

        UsernameInput.setLayoutX(207.0);
        UsernameInput.setLayoutY(86.0);
        UsernameInput.setPromptText("UERSNAME");

        EmailInput.setLayoutX(207.0);
        EmailInput.setLayoutY(139.0);
        EmailInput.setPromptText("EMAIL");

        passwordInput.setLayoutX(207.0);
        passwordInput.setLayoutY(185.0);
        passwordInput.setPromptText("PASSWORD");

        confirmpassInput.setLayoutX(207.0);
        confirmpassInput.setLayoutY(237.0);
        confirmpassInput.setPromptText("CONFIRM PASSWORD");

        confirmButton.setLayoutX(190.0);
        confirmButton.setLayoutY(305.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setPrefHeight(31.0);
        confirmButton.setPrefWidth(106.0);
        confirmButton.setText("CONFIRM");

        backButton.setLayoutX(14.0);
        backButton.setLayoutY(14.0);
        backButton.setMnemonicParsing(false);
        backButton.setText("BACK");

        textSignUp.setLayoutX(200.0);
        textSignUp.setLayoutY(51.0);
        textSignUp.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textSignUp.setStrokeWidth(0.0);
        textSignUp.setText("SIGN UP");
        textSignUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textSignUp.setWrappingWidth(146.99999502301216);
        textSignUp.setFont(new Font(18.0));

        pane2.getChildren().add(UsernameInput);
        pane2.getChildren().add(EmailInput);
        pane2.getChildren().add(passwordInput);
        pane2.getChildren().add(confirmpassInput);
        pane2.getChildren().add(confirmButton);
        pane2.getChildren().add(backButton);
        pane2.getChildren().add(textSignUp);
        pane1.getChildren().add(pane2);
        getChildren().add(pane1);

        backButton.setOnAction((Action) -> {
            Parent root2 = new FXMLSelection(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        confirmButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (UsernameInput.getText().matches("[\\S]+{1,}") && EmailInput.getText().matches("[\\S]+{1,}") && passwordInput.getText().matches("[\\S]+{1,}") && confirmpassInput.getText().matches("[\\S]+{1,}")) {
                    //set values of DTO "player" 
                    if (UsernameInput.getText().matches("([a-zA-Z0-9]{2,})")) {
                        player.setUserName(UsernameInput.getText());
                        if (EmailInput.getText().matches("^[\\w][\\w!#$%&'*+-/=?^_`{|]+@{1}[\\w]+\\.{1}[\\w]{2,4}$")) {
                            player.setEmail(EmailInput.getText());
                            if (passwordInput.getText().compareTo(confirmpassInput.getText()) == 0) {
                                player.setPassword(passwordInput.getText());
                                player.setId(++id);
                                player.SetTotalScoore(0);
                                
                                JSONObject JSObject1 = new JSONObject();
                                JSObject1.put("key", "signup");
                                JSObject1.put("Email",player.getEmail());
                                JSObject1.put("ID",player.getId());
                                JSObject1.put("Username",player.getUserName());
                                JSObject1.put("Password",player.getPassword());
                                JSObject1.put("Score",player.getTootalScoore());
                                Start.printStream.println(JSObject1);
                            } else {
                                new Alert(Alert.AlertType.ERROR, "Password and confirm password didn't match").show();
                            }
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Please enter valid email").show();
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Please enter valid username").show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fill all fields, please").show();
                }
            }
        });

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String reply = Start.dataInputStream.readLine();
                        System.out.println("reply = " + reply);
                        JSONObject object = new JSONObject(reply);
                        boolean rep = object.getBoolean("signup");
                        message = rep;
                        System.out.println("reoly from signup " + reply);
                        if (rep) {
                            Platform.runLater(() -> {
                                System.out.println("Succusseful signup");
                                Parent root2 = new FXMLSignIn(stage);
                                Scene scene2 = new Scene(root2);
                                stage.setScene(scene2);
                                stage.show();
                            });
                        } else {
                            Platform.runLater(() -> {
                                new Alert(Alert.AlertType.ERROR, "Sorry, this email already exists").show();
                            });
                        }
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
                        System.out.println("-------------------------------SignUp in Error in recieve Data-------------------------------");
                        break;

                    }
                    if (message) {
                        break;
                    }
                }
            }
        });
        thread.start();
    }

}
