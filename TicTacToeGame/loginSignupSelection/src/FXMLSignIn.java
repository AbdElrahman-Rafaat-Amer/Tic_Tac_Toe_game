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

public  class FXMLSignIn extends AnchorPane {

    protected final Pane Pane1SingIN;
    protected final Pane pane2SignIn;
    protected final Text textSignIn;
    protected final TextField EmailSignIn;
    protected final TextField PasswordSIgnIn;
    protected final Button ButtonConSingIn;

    public FXMLSignIn(Stage stage) {

        Pane1SingIN = new Pane();
        pane2SignIn = new Pane();
        textSignIn = new Text();
        EmailSignIn = new TextField();
        PasswordSIgnIn = new TextField();
        ButtonConSingIn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        Pane1SingIN.setPrefHeight(400.0);
        Pane1SingIN.setPrefWidth(600.0);

        pane2SignIn.setPrefHeight(400.0);
        pane2SignIn.setPrefWidth(600.0);

        textSignIn.setLayoutX(191.0);
        textSignIn.setLayoutY(66.0);
        textSignIn.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textSignIn.setStrokeWidth(0.0);
        textSignIn.setText("SIGN IN ");
        textSignIn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textSignIn.setWrappingWidth(190.90185546875);

        EmailSignIn.setLayoutX(164.0);
        EmailSignIn.setLayoutY(115.0);
        EmailSignIn.setPrefHeight(31.0);
        EmailSignIn.setPrefWidth(244.0);
        EmailSignIn.setPromptText("EMAIL");

        PasswordSIgnIn.setLayoutX(164.0);
        PasswordSIgnIn.setLayoutY(185.0);
        PasswordSIgnIn.setPrefHeight(31.0);
        PasswordSIgnIn.setPrefWidth(244.0);
        PasswordSIgnIn.setPromptText("PASSWORD");

        ButtonConSingIn.setLayoutX(310.0);
        ButtonConSingIn.setLayoutY(258.0);
        ButtonConSingIn.setMnemonicParsing(false);
        ButtonConSingIn.setPrefHeight(31.0);
        ButtonConSingIn.setPrefWidth(91.0);
        ButtonConSingIn.setText("CONFIRM");
        ButtonConSingIn.setOnAction(event ->  {
         try {
             
             Parent root3 = new FXMLSignIn( stage);
             Scene scene3 = new Scene(root3);
             stage.setScene(scene3);
             stage.show();
             
         
        
    }  
         catch(Exception e) {
             
           e.printStackTrace();
    }
});
        pane2SignIn.getChildren().add(textSignIn);
        pane2SignIn.getChildren().add(EmailSignIn);
        pane2SignIn.getChildren().add(PasswordSIgnIn);
        pane2SignIn.getChildren().add(ButtonConSingIn);
        Pane1SingIN.getChildren().add(pane2SignIn);
        getChildren().add(Pane1SingIN);

    }
}
