package loginsingselection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLSingUpp extends AnchorPane {

    protected final Pane pane1;
    protected final Pane pane2;
    protected final TextField UsernameInput;
    protected final TextField EmailInput;
    protected final TextField passwordInput;
    protected final TextField confirmpassInput;
    protected final Button confirmButton;
    protected final Text signUpText;

    public FXMLSingUpp( Stage stage) {

        pane1 = new Pane();
        pane2 = new Pane();
        UsernameInput = new TextField();
        EmailInput = new TextField();
        passwordInput = new TextField();
        confirmpassInput = new TextField();
        confirmButton = new Button();
        signUpText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        pane1.setLayoutY(3.0);
        pane1.setPrefHeight(394.0);
        pane1.setPrefWidth(600.0);

        pane2.setLayoutY(-14.0);
        pane2.setPrefHeight(422.0);
        pane2.setPrefWidth(600.0);

        UsernameInput.setLayoutX(170.0);
        UsernameInput.setLayoutY(124.0);
        UsernameInput.setPrefHeight(11.0);
        UsernameInput.setPrefWidth(235.0);
        UsernameInput.setPromptText("USERNAME");

        EmailInput.setLayoutX(167.0);
        EmailInput.setLayoutY(177.0);
        EmailInput.setPrefHeight(26.0);
        EmailInput.setPrefWidth(241.0);
        EmailInput.setPromptText("EMAIL");

        passwordInput.setLayoutX(167.0);
        passwordInput.setLayoutY(236.0);
        passwordInput.setPrefHeight(0.0);
        passwordInput.setPrefWidth(241.0);
        passwordInput.setPromptText("PASSWORD");

        confirmpassInput.setLayoutX(167.0);
        confirmpassInput.setLayoutY(294.0);
        confirmpassInput.setPrefHeight(18.0);
        confirmpassInput.setPrefWidth(241.0);
        confirmpassInput.setPromptText("CONFIRM PASSWORD");

        confirmButton.setLayoutX(349.0);
        confirmButton.setLayoutY(357.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setText("CONFIRM");
        confirmButton.setOnAction(event ->  {
         try {
             
             Parent root2 = new FXMLSignIn( stage);
             Scene scene2 = new Scene(root2);
             stage.setScene(scene2);
             stage.show();
       
    }
         catch(Exception e) {
             
        e.printStackTrace();
    }
});
        signUpText.setLayoutX(229.0);
        signUpText.setLayoutY(75.0);
        signUpText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signUpText.setStrokeWidth(0.0);
        signUpText.setText("SIGN UP");
        signUpText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUpText.setWrappingWidth(117.48176574707031);

        pane2.getChildren().add(UsernameInput);
        pane2.getChildren().add(EmailInput);
        pane2.getChildren().add(passwordInput);
        pane2.getChildren().add(confirmpassInput);
        pane2.getChildren().add(confirmButton);
        pane2.getChildren().add(signUpText);
        pane1.getChildren().add(pane2);
        getChildren().add(pane1);

    }
}
