package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    protected final Button backButton;
    Player player = new Player();
    protected static int id = 0;

    public FXMLSingUpp( Stage stage) {

        pane1 = new Pane();
        pane2 = new Pane();
        UsernameInput = new TextField();
        EmailInput = new TextField();
        passwordInput = new TextField();
        confirmpassInput = new TextField();
        confirmButton = new Button();
        backButton = new Button();
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
        
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");
        
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
        pane2.getChildren().add(backButton);
        pane1.getChildren().add(pane2);
        getChildren().add(pane1);
        
        
        backButton.setOnAction((Action)->{
            Parent root2 = new FXMLSelection(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });
        
        
        confirmButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                if(!(UsernameInput.getText().isEmpty())&& !(EmailInput.getText().isEmpty())&& !(passwordInput.getText().isEmpty())&& !(confirmpassInput.getText().isEmpty()))
                {
                    
                    //set values of DTO "player" 
                    if(UsernameInput.getText().length()>2)
                    {
                        player.setUserName(UsernameInput.getText());
                        if(EmailInput.getText().indexOf('@') != -1)
                        {
                            player.setEmail(EmailInput.getText());
                            if(passwordInput.getText().compareTo(confirmpassInput.getText())==0 )
                            {
                                player.setPassword(passwordInput.getText());
                                player.setId(++id);
                                player.SetTotalScoore(0);
                                if(DAO.SignUp(player)==1)
                                    {
                                        System.err.println("Succusseful signup");
                                         try {
                                            Parent root2 = new FXMLSignIn( stage);
                                            Scene scene2 = new Scene(root2);
                                            stage.setScene(scene2);
                                            stage.show();
                                           }catch(Exception e) {e.printStackTrace();}
                                    }
                                else
                                    {System.err.println("UnSuccusseful signup");}
                            }
                            else
                                {System.err.println("password and confirm password didn't match");}
                        }
                         else
                            {System.err.println("Please enter valid email");}
                    }
                    else
                        {System.err.println("Please enter more than 2 char");}
                }
                else
                {
                    System.err.println("fill all fields, please");
                }  
            }
        }); 
    }
}
