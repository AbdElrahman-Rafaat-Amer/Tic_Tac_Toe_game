package loginsingselection;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class FXMLSelection extends AnchorPane {

    protected final Pane Pane1Selc;
    protected final Pane Pane2Selec;
    protected final Button onlineButton;
    protected final Button button;
    protected final Text text;

    public FXMLSelection() {

        Pane1Selc = new Pane();
        Pane2Selec = new Pane();
        onlineButton = new Button();
        button = new Button();
        text = new Text();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        Pane1Selc.setPrefHeight(400.0);
        Pane1Selc.setPrefWidth(600.0);

        Pane2Selec.setPrefHeight(400.0);
        Pane2Selec.setPrefWidth(600.0);

        onlineButton.setLayoutX(270.0);
        onlineButton.setLayoutY(115.0);
        onlineButton.setMnemonicParsing(false);
        onlineButton.setText("ONLINE");

        button.setLayoutX(268.0);
        button.setLayoutY(169.0);
        button.setMnemonicParsing(false);
        button.setText("OFFLINE");

        text.setLayoutX(258.0);
        text.setLayoutY(57.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("CHOOSE");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(95.41552734375);

        Pane2Selec.getChildren().add(onlineButton);
        Pane2Selec.getChildren().add(button);
        Pane2Selec.getChildren().add(text);
        Pane1Selc.getChildren().add(Pane2Selec);
        getChildren().add(Pane1Selc);

    }
}
