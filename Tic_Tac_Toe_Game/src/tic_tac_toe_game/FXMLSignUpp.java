package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import static tic_tac_toe_game.FXMLSingUpp.id;
//import static tic_tac_toe_game.FXMLSingUpp.id;

public  class FXMLSignUpp extends AnchorPane {

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
    
    public FXMLSignUpp( Stage stage) {

        pane1 = new Pane();
        pane2 = new Pane();
        UsernameInput = new TextField();
        EmailInput = new TextField();
        passwordInput = new TextField();
        confirmpassInput = new TextField();
        confirmButton = new Button();
        backButton = new Button();
        textSignUp = new Text();

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

        confirmButton.setLayoutX(320.0);
        confirmButton.setLayoutY(312.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setPrefHeight(31.0);
        confirmButton.setPrefWidth(106.0);
        confirmButton.setText("CONFIRM");

        backButton.setLayoutX(14.0);
        backButton.setLayoutY(14.0);
        backButton.setMnemonicParsing(false);
        backButton.setText("BACK");

        textSignUp.setLayoutX(227.0);
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
                if(!(UsernameInput.getText().trim().isEmpty())&& !(EmailInput.getText().trim().isEmpty())&& !(passwordInput.getText().trim().isEmpty())&& !(confirmpassInput.getText().trim().isEmpty()))
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
