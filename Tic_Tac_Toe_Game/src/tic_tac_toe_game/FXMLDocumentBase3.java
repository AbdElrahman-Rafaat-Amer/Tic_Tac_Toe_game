package gamexo;

import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public  class FXMLDocumentBase3 extends AnchorPane {
  private Stage mystage;
    protected final Button oneplayer;
    protected final MenuButton select;
    protected final MenuItem selectx;
    protected final MenuItem selecto;
    protected final Text player1;
    protected final Text player2;
    protected final TextField player2textfield;

    public FXMLDocumentBase3(Stage stage) {
        mystage =stage;
        oneplayer = new Button();
   
        select = new MenuButton();
        selectx = new MenuItem();
        selecto = new MenuItem();
        player1 = new Text();
        player2 = new Text();
        player2textfield = new TextField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        oneplayer.setLayoutX(252.0);
        oneplayer.setLayoutY(288.0);
        oneplayer.setMnemonicParsing(false);
        oneplayer.setPrefHeight(38.0);
        oneplayer.setPrefWidth(96.0);
        oneplayer.setText("Continue");

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

        getChildren().add(oneplayer);
        select.getItems().add(selectx);
        select.getItems().add(selecto);
        getChildren().add(select);
        getChildren().add(player1);
        getChildren().add(player2);
        getChildren().add(player2textfield);
    }
}
