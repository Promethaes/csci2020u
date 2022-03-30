package com.example.lab06;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String,Number> barChart;
    @FXML
    protected void onDrawButtonClick() {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLUEVIOLET);
        gc.fillOval(10, 60, 100, 100);
    }
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));

        XYChart.Series s1 = new XYChart.Series<>();
        s1.getData().add(new XYChart.Data<>("2010",avgHousingPricesByYear[0]));
        s1.getData().add(new XYChart.Data<>("2011",avgHousingPricesByYear[1]));
        s1.getData().add(new XYChart.Data<>("2012",avgHousingPricesByYear[2]));
        s1.getData().add(new XYChart.Data<>("2013",avgHousingPricesByYear[3]));
        s1.getData().add(new XYChart.Data<>("2014",avgHousingPricesByYear[4]));
        s1.getData().add(new XYChart.Data<>("2015",avgHousingPricesByYear[5]));
        s1.getData().add(new XYChart.Data<>("2016",avgHousingPricesByYear[6]));
        s1.getData().add(new XYChart.Data<>("2017",avgHousingPricesByYear[7]));
        s1.getData().add(new XYChart.Data<>("hey",100));
        XYChart.Series s2 = new XYChart.Series<>();
        s2.getData().add(new XYChart.Data<>("hi",200));
        s2.getData().add(new XYChart.Data<>("hey",200));
        barChart.getData().addAll(s1,s2);

        pieChart.setData(chartData);
    }
}