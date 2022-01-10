package tic_tac_toe_game;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class ResultSceneLoser2 extends VBox {

    protected final AnchorPane anchorPane;
    protected final MediaView videoView;
    protected final Button backToMenu;
    protected final Button playAgin;
    protected final Label label;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    protected static String loser;

    public ResultSceneLoser2(Stage stage) throws MalformedURLException {

        this.stage = stage;
        anchorPane = new AnchorPane();
        backToMenu = new Button();
        playAgin = new Button();
        label = new Label();
        File mediaFile = new File("src\\vedios_media\\waiting vedio.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());
        mediaPlayer = new MediaPlayer(media);
        videoView = new MediaView(mediaPlayer);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(479.0);
        setPrefWidth(666.0);

        anchorPane.setPrefHeight(482.0);
        anchorPane.setPrefWidth(666.0);

        AnchorPane.setLeftAnchor(videoView, 80.0);
        videoView.setFitHeight(250.0);
        videoView.setFitWidth(500.0);
        videoView.setLayoutX(137.0);
        videoView.setLayoutY(88.0);

        backToMenu.setLayoutX(34.0);
        backToMenu.setLayoutY(394.0);
        backToMenu.setMnemonicParsing(false);
        backToMenu.setText("Back to menu");

        playAgin.setLayoutX(562.0);
        playAgin.setLayoutY(394.0);
        playAgin.setMnemonicParsing(false);
        playAgin.setText("Rematch");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(145.0);
        label.setLayoutY(26.0);
        label.setPrefHeight(71.0);
        label.setPrefWidth(384.0);
        label.setText("Label");

        anchorPane.getChildren().add(videoView);
        anchorPane.getChildren().add(backToMenu);
        anchorPane.getChildren().add(playAgin);
        anchorPane.getChildren().add(label);
        getChildren().add(anchorPane);
        mediaPlayer.play();

        backToMenu.setOnAction((Action) -> {
            /*   mediaPlayer.stop();
            Parent root2 = new Start(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();*/
            endVedio();
        });

        playAgin.setOnAction((event) -> {

            Parent parent;
            // try {
            mediaPlayer.stop();
            parent = new GameScene(stage);
            stage.setScene(new Scene(parent));
            stage.show();
            /* } catch (MalformedURLException ex) {
                Logger.getLogger(ResultSceneLoser.class.getName()).log(Level.SEVERE, null, ex);
            }*/

        });

        mediaPlayer.setOnEndOfMedia(() -> {
            endVedio();
        });
    }

    void endVedio() {
        mediaPlayer.stop();
        Parent root2 = new Start(stage);
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();
    }
}
