package tic_tac_toe_game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class XorOSelection extends AnchorPane {

    protected final Button continueButton;
    protected final MenuButton select;
    protected final MenuItem selectx;
    protected final MenuItem selecto;
    protected final Text player1;
    protected final Text player2;
    protected final TextField player2textfield;
    protected final Button backButton;
    private Stage mystage;
    public static String playerOne;
    public static String playerTwo;

    public XorOSelection(Stage stage) {
        System.err.println("XorOSelection");
        continueButton = new Button();
        select = new MenuButton();
        selectx = new MenuItem();
        selecto = new MenuItem();
        player1 = new Text();
        player2 = new Text();
        player2textfield = new TextField();
        backButton = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        continueButton.setLayoutX(252.0);
        continueButton.setLayoutY(288.0);
        continueButton.setMnemonicParsing(false);
        continueButton.setPrefHeight(38.0);
        continueButton.setPrefWidth(96.0);
        continueButton.setText("Continue");

        select.setLayoutX(293.0);
        select.setLayoutY(143.0);
        select.setMnemonicParsing(false);
        select.setPrefHeight(25.0);
        select.setPrefWidth(69.0);
        select.setText("Select ");

        selectx.setMnemonicParsing(false);
        selectx.setText("X");

        selecto.setMnemonicParsing(false);
        selecto.setText("O");

        player1.setLayoutX(144.0);
        player1.setLayoutY(160.0);
        player1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1.setStrokeWidth(0.0);
        player1.setText("Player 1");
        player1.setWrappingWidth(87.99999901652336);

        player2.setLayoutX(144.0);
        player2.setLayoutY(213.0);
        player2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2.setStrokeWidth(0.0);
        player2.setText("Player 2");
        player2.setWrappingWidth(87.99999901652336);

        player2textfield.setEditable(false);
        player2textfield.setLayoutX(293.0);
        player2textfield.setLayoutY(196.0);
        player2textfield.setPrefHeight(25.0);
        player2textfield.setPrefWidth(69.0);

        backButton.setMnemonicParsing(false);
        backButton.setText("Back");

        getChildren().add(continueButton);
        select.getItems().add(selectx);
        select.getItems().add(selecto);
        getChildren().add(select);
        getChildren().add(player1);
        getChildren().add(player2);
        getChildren().add(player2textfield);
        getChildren().add(backButton);

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new SelectPlayersNo(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        selectx.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                select.setText("X");
                playerOne = "X";
                playerTwo = "O";
                player2textfield.setText("O");
            }
        });
        selecto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                select.setText("O");
                playerOne = "O";
                playerTwo = "X";
                player2textfield.setText("X");
            }
        });

        continueButton.setOnAction((Action) -> {
            if ((select.getText() == "X") || (select.getText() == "O")) {
                Parent root2 = new GameTwoPlayersOffline(stage);
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();
            } else {

                new Alert(AlertType.ERROR, "You Must Choose X or O ").show();
            }
        });
    }
}
