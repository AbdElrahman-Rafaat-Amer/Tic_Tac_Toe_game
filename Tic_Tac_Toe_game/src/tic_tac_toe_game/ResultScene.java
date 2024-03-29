package tic_tac_toe_game;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ResultScene extends BorderPane {

    protected final BorderPane borderPane;
    protected final Text resultText;
    protected final BorderPane borderPane0;
    protected final Button backToMenu;
    protected final MediaView videoView;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    protected static String winner;
    private File mediaFile;

    public ResultScene(Stage stage) throws MalformedURLException {
        this.stage = stage;
        borderPane = new BorderPane();
        resultText = new Text();
        borderPane0 = new BorderPane();
        backToMenu = new Button();
        System.out.println(winner);
        if (winner.equals("Player 1 Wins") || winner.equals("Player 2 Wins") || winner.equals("YOU WIN")) {
            mediaFile = new File("src\\vedios_media\\winnerVedio.mp4");
        } else {
            mediaFile = new File("src\\vedios_media\\loserVedio.mp4");
        }

        Media media = new Media(mediaFile.toURI().toURL().toString());
        mediaPlayer = new MediaPlayer(media);
        videoView = new MediaView(mediaPlayer);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
        borderPane.setPrefHeight(71.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(resultText, javafx.geometry.Pos.CENTER);
        resultText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        resultText.setStrokeWidth(0.0);
        resultText.setTextAlignment(TextAlignment.CENTER);
        resultText.setText(winner);
        resultText.setWrappingWidth(170.6689453125);
        borderPane.setCenter(resultText);
        setTop(borderPane);

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);
        borderPane0.setPrefHeight(67.0);
        borderPane0.setPrefWidth(600.0);

        BorderPane.setAlignment(backToMenu, javafx.geometry.Pos.CENTER);
        backToMenu.setMnemonicParsing(false);
        backToMenu.setPrefHeight(38.0);
        backToMenu.setPrefWidth(96.0);
        backToMenu.setText("Skip");
        borderPane0.setCenter(backToMenu);
        setBottom(borderPane0);

        BorderPane.setAlignment(videoView, javafx.geometry.Pos.CENTER);
        videoView.setFitHeight(200.0);
        videoView.setFitWidth(300.0);
        setCenter(videoView);

        mediaPlayer.play();

        backToMenu.setOnAction((Action) -> {
            /*   mediaPlayer.stop();
            Parent root2 = new Start(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();*/
            endVedio();
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
