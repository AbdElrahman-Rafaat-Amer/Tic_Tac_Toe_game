package server;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public  class Servertictactoe extends AnchorPane {

    protected final ToggleButton startServer;
    protected final CategoryAxis categoryAxis;
    protected final NumberAxis numberAxis;
    protected final AreaChart areaChart;
    private Stage mystage;
    
    public Servertictactoe(Stage stage) {

        startServer = new ToggleButton();
        categoryAxis = new CategoryAxis();
        numberAxis = new NumberAxis();
        areaChart = new AreaChart(categoryAxis, numberAxis);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        startServer.setLayoutX(233.0);
        startServer.setLayoutY(131.0);
        startServer.setMnemonicParsing(false);
        startServer.setText("Start Server");

        categoryAxis.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis.setSide(javafx.geometry.Side.LEFT);
        areaChart.setLayoutX(129.0);
        areaChart.setLayoutY(209.0);
        areaChart.setPrefHeight(162.0);
        areaChart.setPrefWidth(268.0);

        getChildren().add(startServer);
        getChildren().add(areaChart);

    }
}
