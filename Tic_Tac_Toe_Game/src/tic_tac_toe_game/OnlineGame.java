package tic_tac_toe_game;

import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import static tic_tac_toe_game.Start.server;

public  class OnlineGame extends BorderPane {

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
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
      Start start;
      private boolean turnX = true;
    private boolean gameOver = false;
    ArrayList<Label> labels;
    
   // private Socket server;
    //DataInputStream dis;
    //PrintStream ps;
    
    public OnlineGame( Stage stage) {

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
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();

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
        Player2Text.setText("Player 2");
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

        label1.setLayoutX(154.0);
        label1.setLayoutY(18.0);
        label1.setPrefHeight(41.0);
        label1.setPrefWidth(87.0);

        label2.setLayoutX(257.0);
        label2.setLayoutY(23.0);
        label2.setPrefHeight(46.0);
        label2.setPrefWidth(75.0);

        label3.setLayoutX(350.0);
        label3.setLayoutY(17.0);
        label3.setPrefHeight(49.0);
        label3.setPrefWidth(75.0);

        label4.setLayoutX(148.0);
        label4.setLayoutY(83.0);
        label4.setPrefHeight(39.0);
        label4.setPrefWidth(89.0);

        label5.setLayoutX(256.0);
        label5.setLayoutY(83.0);
        label5.setPrefHeight(45.0);
        label5.setPrefWidth(76.0);

        label6.setLayoutX(350.0);
        label6.setLayoutY(79.0);
        label6.setPrefHeight(48.0);
        label6.setPrefWidth(75.0);
        label6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label7.setLayoutX(162.0);
        label7.setLayoutY(144.0);
        label7.setPrefHeight(46.0);
        label7.setPrefWidth(76.0);
        label7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label8.setLayoutX(258.0);
        label8.setLayoutY(144.0);
        label8.setPrefHeight(51.0);
        label8.setPrefWidth(71.0);
        label8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label9.setLayoutX(350.0);
        label9.setLayoutY(145.0);
        label9.setPrefHeight(46.0);
        label9.setPrefWidth(78.0);
        label9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
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
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        anchorPane.getChildren().add(label5);
        anchorPane.getChildren().add(label6);
        anchorPane.getChildren().add(label7);
        anchorPane.getChildren().add(label8);
        anchorPane.getChildren().add(label9);
 
       // try {
           
       // server = new Socket("127.0.0.1", 5005);
        //ps = new PrintStream(server.getOutputStream());
        //dis = new DataInputStream(server.getInputStream());
        
//        ps.println("Turn X");


        

        new Thread(){

            @Override
            public void run() {
                while(true){
                    
                    try {
                         String msg = Start.dataInputStream.readLine();
                       
                        //String msg = dis.readLine();
                        System.out.println("client: " + msg);
                        JSONObject obj = new JSONObject(msg);
                        System.out.println(obj.getString("turn"));
                        System.out.println(obj.getString("square"));
                        
                        String turn = obj.getString("turn");
                        String square = obj.getString("square");
                        
                        switch(square){

                                case "label1":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label1.setText(turn);
                                        label1.setDisable(true);
                                    }

                                    });
                                    
                                    break;

                                case "label2":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label2.setText(turn);
                                        label2.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label3":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label3.setText(turn);
                                        label3.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label4":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label4.setText(turn);
                                        label4.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label5":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label5.setText(turn);
                                        label5.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label6":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label6.setText(turn);
                                        label6.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label7":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label7.setText(turn);
                                        label7.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label8":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label8.setText(turn);
                                        label8.setDisable(true);
                                    }

                                    });
                                    break;

                                case "label9":
                                    Platform.runLater(new Runnable(){
                                    @Override
                                    public void run() {
                                        label9.setText(turn);
                                        label9.setDisable(true);
                                    }

                                    });
                                    break;
                                    
                                default: 
                                    System.out.println("error");
                            }
                        
                    } catch (IOException ex) {
                        Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
                    } //catch (JSONException ex) {
                        //Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
                    //}
                }
            }

        }.start();

       // }  catch (IOException ex) {
        //    Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
        
        
//        setLabelWithSymbol(label1, "X");

    }
    
    private void setLabelWithSymbol(Label label, String turn){
        setClientSymbol(label, turn);
        label.setDisable(true);
    }
    
    public void setClientSymbol (Label label, String turn){
        
        label.setText(turn);
        
    }
    
    
    private void setUpLabels(Label label){
        
        JSONObject obj = new JSONObject();
        
        label.setOnMouseClicked( mouseEvent ->{
            
            if(!gameOver){
                
                try {
                   // server = new Socket("127.0.0.1", 5005);
                    //ps = new PrintStream(server.getOutputStream());
                    //dis = new DataInputStream(server.getInputStream());

                    boolean turnX = setPlayerSymbol(label);
                    label.setDisable(true);

                    String turn = "";
                    if(!turnX){ turn = "X"; } else { turn = "O"; }
                    obj.put("key", "onlineMoves");
                    obj.put("turn", turn);
                    obj.put("square", label.getId());
                      Start.printStream.println(obj);
                      Start.printStream.println("Turn X");
//                    ps.println(obj.toString());
                   // ps.println(obj);
                   // ps.println("Turn X");

                    checkGameIsOver();

                } catch (JSONException ex) {
                      Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
                } //catch(IOException iex){
                    //Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, iex);
                //}

           }
        });
    }
      
    
    public boolean setPlayerSymbol (Label label){
          JSONObject obj = new JSONObject();
          if (turnX == true){
              try {
                  
                  label.setText("X");
//                  System.out.println("player X played On: " + label.getId());
                  obj.put("key", "onlineMoves");
                  obj.put("turn", "x");
                  obj.put("square", label.getId());
//                  turnX = false;
                  
//                  ps.println(obj.toString());
                     Start.printStream.println(obj);
                     // Start.printStream.println("Turn X");
                  //ps.println(obj);
                    turnX = false;
//                  ps.println("Turn X");
              } catch (JSONException ex) {
                  Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
          else {
              try {
                  label.setText("O");
//                  System.out.println("player O played On: " + label.getId());
                  
//                  ps.println("Turn O");
                  obj.put("turn", "o");
                  obj.put("square", label.getId());
//                  turnX = true;
                  
//                  ps.println(obj.toString());
                  //ps.println(obj);
                  Start.printStream.println(obj);
                  turnX = true;
              } catch (JSONException ex) {
                  Logger.getLogger( OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          return turnX;
      }
    
    
    public void checkGameIsOver(){
          
        for (int a = 0 ; a < 8; a++){

            String line = "" ;

            switch(a){

                case 0 :
                    line = label1.getText()+label2.getText()+label3.getText();
                     break;

                case 1 :
                    line = label4.getText()+label5.getText()+label6.getText();
                    break;

                case 2 :
                    line = label7.getText()+label8.getText()+label9.getText();
                    break;

                case 3 :
                    line = label3.getText()+label5.getText()+label7.getText();
                    break;

                case 4 :
                    line = label1.getText()+label4.getText()+label6.getText();
                    break;

                case 5 :
                    line = label2.getText()+label5.getText()+label8.getText();
                    break;

                case 6 :
                    line = label3.getText()+label6.getText()+label9.getText(); 
                    break;

                case 7 :
                    line = label1.getText()+label5.getText()+label9.getText(); 
                    break;

                default : line="";

            }

            if (line.equals("XXX")){
     //           Score1Text.setText("1");
               System.out.println("Player X wins");
               gameOver = true;

            }
            else if( line.equals("OOO")){
     //          Score1Text.setText("o");
               System.out.println("Player O wins");
               gameOver = true;
            } 

        }
        
    }
}
