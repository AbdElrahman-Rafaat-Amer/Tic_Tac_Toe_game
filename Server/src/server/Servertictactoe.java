
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;
import static server.Handler.avaliablePlayers;


public  class Servertictactoe extends AnchorPane {

    protected final ToggleButton startServer;
    protected final PieChart piechart;
     private Stage mystage;
    ServerSocket serverSocket;
    public Servertictactoe(Stage stage) {
        
            startServer = new ToggleButton();
            ObservableList<PieChart.Data> pieChartData = null;
            piechart = new PieChart(pieChartData);

        try {
             int tottalPlayer =DAO.numberOfPlayers();
             int avilablePlayer=Handler.clientsVector.size();
             int offlinePlayer=tottalPlayer-avilablePlayer;
            pieChartData = FXCollections.observableArrayList(
                    
                new PieChart.Data("Tottal Players" , DAO.numberOfPlayers())); //totaal in database
               // new PieChart.Data("Avilable Players",onlinevector )); //onlinevector
               // new PieChart.Data("Tottalll players" , 6), //totaal in database
              //  new PieChart.Data("Avilable players",5 ),
                
                piechart.setLabelLineLength(50); 
                piechart.setLegendVisible(true);
                piechart.setLabelLineLength(50);
                piechart.setLegendSide(Side.LEFT);
              
            //onlinevector
            System.out.println(Handler.clientsVector.size());
            System.out.println(DAO.numberOfPlayers());
             piechart.setClockwise(true); 
             piechart.setTitle(" Chart Of Players"); 

           //piechart.setLabelsVisible(true); 
            piechart.setData(pieChartData);
        } catch (SQLException ex) {
            Logger.getLogger(Servertictactoe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        startServer.setLayoutX(233.0);
        startServer.setLayoutY(131.0);
        startServer.setMnemonicParsing(false);
        startServer.setText("Server ON");

        piechart.setLayoutX(189.0);
        piechart.setLayoutY(200.0);
        piechart.setPrefHeight(200.0);
        piechart.setPrefWidth(210.0);

        getChildren().add(startServer);
        getChildren().add(piechart);

        
                if (startServer.getText() == "Server ON") {
            startServer.setText("Server OFF");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        serverSocket = new ServerSocket(5005);
                        while (true) {
                            socket = serverSocket.accept();
                            new Handler(socket);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();

        }

    }
}