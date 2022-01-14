package tic_tac_toe_game;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;


public class GameScene extends BorderPane {

    protected final BorderPane borderPane;
    protected final FlowPane flowPane;
    protected final BorderPane borderPane0;
    protected final Line line;
    protected final FlowPane flowPane0;
    protected final Text Player1Text;
    protected final Text Score1Text;
    protected final Text ONotationText;
    protected final FlowPane flowPane1;
    protected final BorderPane borderPane1;
    protected final Line line0;
    protected final FlowPane flowPane2;
    protected final Text Player2Text;
    protected final Text Score1Text1;
    protected final Text XNotationText;
    protected final BorderPane borderPane2;
    protected final FlowPane flowPane3;
    protected final MenuButton menuList;
    protected final MenuItem homeButton;
    protected final MenuItem resetButton;
    protected final Text gameText;
    protected final AnchorPane anchorPane;
    protected final Line HLine1;
    protected final Line VLine2;
    protected final Line HLine2;
    protected final Line VLine1;
    protected final Pane pane1;
    protected final Label labelPane1;
    protected final Pane pane2;
    protected final Label labelPane2;
    protected final Pane pane3;
    protected final Label labelPane3;
    protected final Pane pane4;
    protected final Label labelPane4;
    protected final Pane pane5;
    protected final Label labelPane5;
    protected final Pane pane6;
    protected final Label labelPane6;
    protected final Pane pane7;
    protected final Label labelPane7;
    protected final Pane pane8;
    protected final Label labelPane8;
    protected final Pane pane9;
    protected final Label labelPane9;
    protected static String text;
    protected String[] values = new String[9];
    static int i = 0;
    //protected static String winner;
    private String level;
    private Game.NextMove computerMove;
    private int moveNumber = 0;
    private Stage stage;
    private int score = 0;
    private boolean isPlayer = true;

    public GameScene(Stage stage) {
        this.stage = stage;
        level = LevelPage.level;
        borderPane = new BorderPane();
        flowPane = new FlowPane();
        borderPane0 = new BorderPane();
        line = new Line();
        flowPane0 = new FlowPane();
        Player1Text = new Text();
        Score1Text = new Text();
        ONotationText = new Text();
        flowPane1 = new FlowPane();
        borderPane1 = new BorderPane();
        line0 = new Line();
        flowPane2 = new FlowPane();
        Player2Text = new Text();
        Score1Text1 = new Text();
        XNotationText = new Text();
        borderPane2 = new BorderPane();
        flowPane3 = new FlowPane();
        menuList = new MenuButton();
        homeButton = new MenuItem();
        resetButton = new MenuItem();
        gameText = new Text();
        anchorPane = new AnchorPane();
        HLine1 = new Line();
        VLine2 = new Line();
        HLine2 = new Line();
        VLine1 = new Line();
        pane1 = new Pane();
        labelPane1 = new Label();
        pane2 = new Pane();
        labelPane2 = new Label();
        pane3 = new Pane();
        labelPane3 = new Label();
        pane4 = new Pane();
        labelPane4 = new Label();
        pane5 = new Pane();
        labelPane5 = new Label();
        pane6 = new Pane();
        labelPane6 = new Label();
        pane7 = new Pane();
        labelPane7 = new Label();
        pane8 = new Pane();
        labelPane8 = new Label();
        pane9 = new Pane();
        labelPane9 = new Label();
        Label board[][] = {{labelPane1, labelPane2, labelPane3}, {labelPane4, labelPane5, labelPane6}, {labelPane7, labelPane8, labelPane9}};

         // XNotationText.getStylesheets().add("/CssStyles/CssStyles.css");
         XNotationText.getStyleClass().add("xo"); 
         ONotationText.getStyleClass().add("xo");      
         getStylesheets().add("/CssStyles/CssStyles.css");
         getStyleClass().add("gameimage");
        // menuList.getStylesheets().add("/CssStyles/CssStyles.css");
        // menuList.getStyleClass.add("btn");
       
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
        borderPane.setPrefHeight(93.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);

        borderPane0.setPrefHeight(45.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(line, javafx.geometry.Pos.CENTER);
        line.setEndX(463.89715576171875);
        line.setEndY(-25.348709106445312);
        line.setStartX(369.604248046875);
        line.setStartY(-25.348724365234375);
        borderPane0.setCenter(line);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(61.0);
        flowPane0.setPrefWidth(200.0);

        Player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Player1Text.setStrokeWidth(0.0);
        Player1Text.setText("Player 1");
        Player1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Player1Text.setWrappingWidth(198.134765625);

        Score1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Score1Text.setStrokeWidth(0.0);
        Score1Text.setText("Score");
        Score1Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Score1Text.setWrappingWidth(195.3603515625);
        borderPane0.setBottom(flowPane0);

        BorderPane.setAlignment(ONotationText, javafx.geometry.Pos.CENTER);
        ONotationText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ONotationText.setStrokeWidth(0.0);
        ONotationText.setText("O");
        borderPane0.setTop(ONotationText);
        borderPane.setLeft(flowPane);

        BorderPane.setAlignment(flowPane1, javafx.geometry.Pos.CENTER);
        flowPane1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        flowPane1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane1.setPrefHeight(200.0);
        flowPane1.setPrefWidth(200.0);
        borderPane1.setPrefHeight(45.0);
        borderPane1.setPrefWidth(200.0);

        BorderPane.setAlignment(line0, javafx.geometry.Pos.CENTER);
        line0.setEndX(463.89715576171875);
        line0.setEndY(-25.348709106445312);
        line0.setStartX(369.604248046875);
        line0.setStartY(-25.348724365234375);
        borderPane1.setCenter(line0);

        BorderPane.setAlignment(flowPane2, javafx.geometry.Pos.CENTER);
        flowPane2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        flowPane2.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane2.setPrefHeight(61.0);
        flowPane2.setPrefWidth(200.0);

        Player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Player2Text.setStrokeWidth(0.0);
        if (SelectPlayersNo.isSingle) {
            Player2Text.setText("Computer");
        } else {
            Player2Text.setText("Player 2");
        }
        Player2Text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Player2Text.setWrappingWidth(198.134765625);

        Score1Text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Score1Text1.setStrokeWidth(0.0);
        Score1Text1.setText("Score");
        Score1Text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Score1Text1.setWrappingWidth(195.3603515625);
        borderPane1.setBottom(flowPane2);

        BorderPane.setAlignment(XNotationText, javafx.geometry.Pos.CENTER);
        XNotationText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        XNotationText.setStrokeWidth(0.0);
        XNotationText.setText("X");
        borderPane1.setTop(XNotationText);
        borderPane.setRight(flowPane1);
        setBottom(borderPane);

        BorderPane.setAlignment(borderPane2, javafx.geometry.Pos.CENTER);
        borderPane2.setPrefHeight(83.0);
        borderPane2.setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane3, javafx.geometry.Pos.CENTER);
        flowPane3.setPrefHeight(24.0);
        flowPane3.setPrefWidth(600.0);

        menuList.setMnemonicParsing(false);
        menuList.setPrefHeight(21.0);
        menuList.setPrefWidth(92.0);
        menuList.setText("Menu");

        homeButton.setMnemonicParsing(false);
        homeButton.setText("Home");

        resetButton.setMnemonicParsing(false);
        resetButton.setText("Reset");
        borderPane2.setTop(flowPane3);

        BorderPane.setAlignment(gameText, javafx.geometry.Pos.CENTER);
        gameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gameText.setStrokeWidth(0.0);
        gameText.setText("Game");
        gameText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameText.setWrappingWidth(98.8447265625);
        gameText.setFont(new Font(18.0));
        borderPane2.setCenter(gameText);
        setTop(borderPane2);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(239.0);
        anchorPane.setPrefWidth(600.0);

        HLine1.setEndX(135.0);
        HLine1.setLayoutX(295.0);
        HLine1.setLayoutY(75.0);
        HLine1.setStartX(-138.0);

        VLine2.setEndX(52.0);
        VLine2.setEndY(48.0);
        VLine2.setLayoutX(290.0);
        VLine2.setLayoutY(149.0);
        VLine2.setStartX(52.0);
        VLine2.setStartY(-123.0);

        HLine2.setEndX(130.0);
        HLine2.setLayoutX(301.0);
        HLine2.setLayoutY(137.0);
        HLine2.setStartX(-143.0);

        VLine1.setEndX(-17.0);
        VLine1.setEndY(79.0);
        VLine1.setLayoutX(266.0);
        VLine1.setLayoutY(118.0);
        VLine1.setStartX(-17.0);
        VLine1.setStartY(-91.0);

        pane1.setLayoutX(157.0);
        pane1.setLayoutY(26.0);
        pane1.setPrefHeight(52.0);
        pane1.setPrefWidth(91.0);

        labelPane1.setLayoutX(-2.0);
        labelPane1.setLayoutY(1.0);
        labelPane1.setPrefHeight(46.0);
        labelPane1.setPrefWidth(94.0);

        pane2.setLayoutX(250.0);
        pane2.setLayoutY(23.0);
        pane2.setPrefHeight(51.0);
        pane2.setPrefWidth(93.0);

        labelPane2.setPrefHeight(54.0);
        labelPane2.setPrefWidth(94.0);

        pane3.setLayoutX(343.0);
        pane3.setLayoutY(24.0);
        pane3.setPrefHeight(53.0);
        pane3.setPrefWidth(85.0);

        labelPane3.setLayoutY(-2.0);
        labelPane3.setPrefHeight(53.0);
        labelPane3.setPrefWidth(89.0);

        pane4.setLayoutX(159.0);
        pane4.setLayoutY(76.0);
        pane4.setPrefHeight(62.0);
        pane4.setPrefWidth(88.0);

        labelPane4.setLayoutX(-1.0);
        labelPane4.setPrefHeight(61.0);
        labelPane4.setPrefWidth(89.0);

        pane5.setLayoutX(250.0);
        pane5.setLayoutY(78.0);
        pane5.setPrefHeight(57.0);
        pane5.setPrefWidth(91.0);

        labelPane5.setLayoutX(-1.0);
        labelPane5.setLayoutY(1.0);
        labelPane5.setPrefHeight(56.0);
        labelPane5.setPrefWidth(94.0);

        pane6.setLayoutX(343.0);
        pane6.setLayoutY(78.0);
        pane6.setPrefHeight(58.0);
        pane6.setPrefWidth(92.0);

        labelPane6.setLayoutY(-2.0);
        labelPane6.setPrefHeight(61.0);
        labelPane6.setPrefWidth(87.0);

        pane7.setLayoutX(157.0);
        pane7.setLayoutY(138.0);
        pane7.setPrefHeight(62.0);
        pane7.setPrefWidth(93.0);

        labelPane7.setLayoutY(-1.0);
        labelPane7.setPrefHeight(62.0);
        labelPane7.setPrefWidth(91.0);

        pane8.setLayoutX(252.0);
        pane8.setLayoutY(135.0);
        pane8.setPrefHeight(61.0);
        pane8.setPrefWidth(90.0);

        labelPane8.setLayoutX(-2.0);
        labelPane8.setLayoutY(3.0);
        labelPane8.setPrefHeight(59.0);
        labelPane8.setPrefWidth(93.0);

        pane9.setLayoutX(343.0);
        pane9.setLayoutY(140.0);
        pane9.setPrefHeight(56.0);
        pane9.setPrefWidth(92.0);

        labelPane9.setLayoutX(-2.0);
        labelPane9.setLayoutY(-3.0);
        labelPane9.setPrefHeight(60.0);
        labelPane9.setPrefWidth(93.0);
        setCenter(anchorPane);

        flowPane0.getChildren().add(Player1Text);
        flowPane0.getChildren().add(Score1Text);
        flowPane.getChildren().add(borderPane0);
        flowPane2.getChildren().add(Player2Text);
        flowPane2.getChildren().add(Score1Text1);
        flowPane1.getChildren().add(borderPane1);
        menuList.getItems().add(homeButton);
        menuList.getItems().add(resetButton);
        flowPane3.getChildren().add(menuList);
        anchorPane.getChildren().add(HLine1);
        anchorPane.getChildren().add(VLine2);
        anchorPane.getChildren().add(HLine2);
        anchorPane.getChildren().add(VLine1);
        pane1.getChildren().add(labelPane1);
        anchorPane.getChildren().add(pane1);
        pane2.getChildren().add(labelPane2);
        anchorPane.getChildren().add(pane2);
        pane3.getChildren().add(labelPane3);
        anchorPane.getChildren().add(pane3);
        pane4.getChildren().add(labelPane4);
        anchorPane.getChildren().add(pane4);
        pane5.getChildren().add(labelPane5);
        anchorPane.getChildren().add(pane5);
        pane6.getChildren().add(labelPane6);
        anchorPane.getChildren().add(pane6);
        pane7.getChildren().add(labelPane7);
        anchorPane.getChildren().add(pane7);
        pane8.getChildren().add(labelPane8);
        anchorPane.getChildren().add(pane8);
        pane9.getChildren().add(labelPane9);
        anchorPane.getChildren().add(pane9);

        homeButton.setOnAction((Action) -> {
            Parent root2 = new Start(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        resetButton.setOnAction((Action) -> {
            Parent root2 = new GameScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        });

        //to set X and O fro each player
        ONotationText.setText(XorOSelection.playerOne);
        if (XorOSelection.playerOne == "X") {
            XNotationText.setText("O");
        } else {
            ONotationText.setText("O");

        }
        text = XNotationText.getText();

        //to set labels text in the center 
        labelPane1.setAlignment(Pos.CENTER);
        labelPane2.setAlignment(Pos.CENTER);
        labelPane3.setAlignment(Pos.CENTER);
        labelPane4.setAlignment(Pos.CENTER);
        labelPane5.setAlignment(Pos.CENTER);
        labelPane6.setAlignment(Pos.CENTER);
        labelPane7.setAlignment(Pos.CENTER);
        labelPane8.setAlignment(Pos.CENTER);
        labelPane9.setAlignment(Pos.CENTER);

        for (Label[] row : board) {
            for (Label cell : row) {

                switch (level) {
                    case "easy":
                        cell.setOnMouseClicked((event) -> {
                            if (isPlayer == true) {
                                //player play
                                cell.setText("O");
                                cell.setMouseTransparent(true);
                                moveNumber++;
                                //check if there are 9 moves if true the computer will not play 
                                if (moveNumber < 9) {
                                    isPlayer = false;
                                    computerMove = EasyLevel.moveNext(board);
                                    Thread t = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {

                                            }
                                            Platform.runLater(() -> {
                                                board[computerMove.row][computerMove.col].setText("X");
                                                board[computerMove.row][computerMove.col].setMouseTransparent(true);
                                                moveNumber++;
                                                isPlayer = true;
                                            });
                                            if (moveNumber >= 5) {
                                                Platform.runLater(() -> {

                                                    score = Game.checkWinner(board);
                                                    if (score != 0) {
                                                        Game.goToWinnerPage(stage);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                    t.start();
                                } else {

                                    score = Game.checkWinner(board);
                                    if (score == 0) {
                                        ResultScene.winner = "TIE";
                                        Game.goToWinnerPage(stage);
                                    } else {
                                        ResultScene.winner = "You Win";
                                        Game.goToWinnerPage(stage);
                                    }
                                }

                            }
                        });
                        break;

                    case "medium":
                        cell.setOnMouseClicked((event) -> {
                            if (isPlayer == true) {
                                //player play
                                cell.setText("O");
                                cell.setMouseTransparent(true);
                                moveNumber++;
                                //check if there are 9 moves if true the computer will not play 
                                if (moveNumber < 9) {
                                    isPlayer = false;
                                    computerMove = MediumLevel.moveNext(board);
                                    Thread t = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {

                                            }
                                            Platform.runLater(() -> {
                                                board[computerMove.row][computerMove.col].setText("X");
                                                board[computerMove.row][computerMove.col].setMouseTransparent(true);
                                                moveNumber++;
                                                isPlayer = true;
                                            });
                                            if (moveNumber >= 5) {
                                                Platform.runLater(() -> {

                                                    score = Game.checkWinner(board);
                                                    if (score != 0) {
                                                        Game.goToWinnerPage(stage);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                    t.start();
                                } else {

                                    score = Game.checkWinner(board);
                                    if (score == 0) {
                                        ResultScene.winner = "TIE";
                                        Game.goToWinnerPage(stage);
                                    } else {
                                        ResultScene.winner = "You Win";
                                        Game.goToWinnerPage(stage);
                                    }
                                }
                            }
                        });
                        System.err.println("you are in medium level");
                        break;

                    case "hard":
                        cell.setOnMouseClicked((event) -> {
                            if (isPlayer == true) {
                                //player play
                                cell.setText("O");
                                cell.setMouseTransparent(true);
                                moveNumber++;
                                //check if there are 9 moves if true the computer will not play
                                if (moveNumber < 9) {
                                    isPlayer = false;
                                    computerMove = HardLevel.moveNext(board);
                                    Thread t = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {

                                            }
                                            Platform.runLater(() -> {

                                                board[computerMove.row][computerMove.col].setText("X");
                                                board[computerMove.row][computerMove.col].setMouseTransparent(true);
                                                isPlayer = true;
                                                moveNumber++;
                                            });
                                            if (moveNumber >= 5) {
                                                Platform.runLater(() -> {
                                                    score = Game.checkWinner(board);
                                                    if (score != 0) {
                                                        Game.goToWinnerPage(stage);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                    t.start();
                                } else {
                                    score = Game.checkWinner(board);
                                    if (score == 0) {
                                        ResultScene.winner = "TIE";
                                        Game.goToWinnerPage(stage);
                                    } else {
                                        ResultScene.winner = "You Win";
                                        Game.goToWinnerPage(stage);
                                    }
                                }
                            }
                        });
                        break;
                }
            }
        }
    }

}
