package tic_tac_toe_game;

import com.sun.javafx.charts.ChartLayoutAnimator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public FXMLSignIn(Stage stage) {

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
            if (!email.isEmpty() && !password.isEmpty()) {
                DAO.connection();
                boolean resualt = DAO.checkLogin(email, password);
                if (resualt) {
                    RequestPage.email = email;
                    Parent root2 = new RequestPage(stage);
                    Scene scene2 = new Scene(root2);
                    stage.setScene(scene2);
                    stage.show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();
                }
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
}
