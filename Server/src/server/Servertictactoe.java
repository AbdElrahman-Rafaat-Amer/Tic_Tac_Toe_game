package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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

public class Servertictactoe extends AnchorPane {

    protected final ToggleButton startServer;
    protected final PieChart piechart;
    private Stage mystage;
    ServerSocket serverSocket;
    Thread thread;
    ObservableList<PieChart.Data> pieChartData = null;
    int tottalPlayer;
    int avilablePlayer;
    int offlinePlayer;

    public Servertictactoe(Stage stage) {

        startServer = new ToggleButton();

        piechart = new PieChart(pieChartData);

        try {
            tottalPlayer = DAO.numberOfPlayers();
            avilablePlayer = Handler.clientsVector.size();
            offlinePlayer = tottalPlayer - avilablePlayer;
            System.out.println("tottalPlayer first time" + tottalPlayer);
            System.out.println("avilablePlayer first time" + avilablePlayer);
            System.out.println("offlinePlayer first time" + offlinePlayer);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            tottalPlayer = DAO.numberOfPlayers();
                            avilablePlayer = Handler.clientsVector.size();
                            offlinePlayer = tottalPlayer - avilablePlayer;

                            pieChartData = FXCollections.observableArrayList(
                                    new PieChart.Data("offlinePlayer", offlinePlayer), //offlinePlayer
                                    new PieChart.Data("Avilable Players", avilablePlayer)); //onlinevector

                            Platform.runLater(() -> {
                                piechart.setData(pieChartData);
                            });

                            System.out.println("tottalPlayer after update" + tottalPlayer);
                            System.out.println("avilablePlayer after update" + avilablePlayer);
                            System.out.println("offlinePlayer after update" + offlinePlayer);
                            System.out.println("-------------------------------------------------------------------------------------------");
                        } catch (SQLException ex) {
                            Logger.getLogger(Servertictactoe.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Servertictactoe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }).start();
            /* pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("offline Player", offlinePlayer),
                    new PieChart.Data("Avilable Players", avilablePlayer));
            System.out.println("avilablePlayer in chart" + avilablePlayer);*/
            System.out.println("offlinePlayer  in chart" + offlinePlayer);

            piechart.setLabelLineLength(50);
            piechart.setLegendVisible(true);
            piechart.setLabelLineLength(50);
            piechart.setLegendSide(Side.LEFT);

            //onlinevector
            //   System.out.println(Handler.clientsVector.size());
            //   System.out.println(DAO.numberOfPlayers());
            piechart.setClockwise(true);
            piechart.setTitle(" Chart Of Players");

            //piechart.setLabelsVisible(true); 
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

        startServer.setOnAction((event) -> {
            if (startServer.getText() == "Server ON") {
                startServer.setText("Server OFF");
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Socket socket;
                        try {
                            System.out.println("Server start");
                            serverSocket = new ServerSocket(5005);
                            while (true) {
                                socket = serverSocket.accept();
                                new Handler(socket);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                thread.start();
            } else {
                System.out.println("Server stop");
                try {
                    thread.suspend();
                    serverSocket.close();
                    startServer.setText("Server ON");
                    for (Handler h : Handler.clientsVector) {
                        h.printStream.close();
                        h.dataInputStream.close();
                        h.stop();
                    }

                    for (Handler h : Handler.onlinePlayers) {
                        h.printStream.close();
                        h.dataInputStream.close();
                        h.stop();
                    }
                    Handler.clientsVector = new Vector<Handler>();
                    Handler.onlinePlayers = new Vector<Handler>();
                } catch (IOException ex) {
                    Logger.getLogger(Servertictactoe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
