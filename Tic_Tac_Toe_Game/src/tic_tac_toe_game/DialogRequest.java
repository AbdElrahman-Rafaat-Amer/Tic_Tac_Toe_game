package tic_tac_toe_game;

import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class DialogRequest extends AnchorPane {

    protected final DialogPane dialogPane;
    protected final AnchorPane anchorPane;
    protected final Text textDialog;
    protected final Button ButtonYes;
    protected final Button ButtonNo;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;

    public DialogRequest(Stage stage) {

        dialogPane = new DialogPane();
        anchorPane = new AnchorPane();
        textDialog = new Text();
        ButtonYes = new Button();
        ButtonNo = new Button();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();

        setId("AnchorPane");
        setPrefHeight(269.0);
        setPrefWidth(414.0);

        dialogPane.setLayoutX(27.0);
        dialogPane.setLayoutY(8.0);
        dialogPane.setMaxHeight(USE_PREF_SIZE);
        dialogPane.setMaxWidth(USE_PREF_SIZE);
        dialogPane.setMinHeight(USE_PREF_SIZE);
        dialogPane.setMinWidth(USE_PREF_SIZE);
        dialogPane.setPrefHeight(274.0);
        dialogPane.setPrefWidth(361.0);

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(377.0);

        textDialog.setLayoutX(26.0);
        textDialog.setLayoutY(107.0);
        textDialog.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textDialog.setStrokeWidth(0.0);
        textDialog.setText("do you want to accept the request?");
        textDialog.setWrappingWidth(309.6708984375);
        textDialog.setFont(new Font(18.0));

        ButtonYes.setLayoutX(92.0);
        ButtonYes.setLayoutY(143.0);
        ButtonYes.setMnemonicParsing(false);
        ButtonYes.setText("Yes");

        ButtonNo.setLayoutX(203.0);
        ButtonNo.setLayoutY(143.0);
        ButtonNo.setMnemonicParsing(false);
        ButtonNo.setText("No");
        dialogPane.setHeader(anchorPane);

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(320.0);
        dialogPane.setExpandableContent(anchorPane0);

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(320.0);
        dialogPane.setGraphic(anchorPane1);

        anchorPane.getChildren().add(textDialog);
        anchorPane.getChildren().add(ButtonYes);
        anchorPane.getChildren().add(ButtonNo);
        getChildren().add(dialogPane);

    }
}
