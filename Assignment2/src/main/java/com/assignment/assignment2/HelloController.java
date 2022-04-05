package com.assignment.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private BarChart<String,Number> barChart;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //make file reading calls here
        //compute average and store here
        ArrayList<ArrayList<Integer>> mins = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> maxs = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> averages = new ArrayList<ArrayList<Integer>>();

//        DataBase.data.add(new ArrayList<String>());
//        DataBase.data.add(new ArrayList<String>());
//        DataBase.data.get(1).add("name");
//        DataBase.data.get(1).add("1");
//
//        //cols
//        for (int i = 1; i < DataBase.data.size(); i++) {
//            mins.add(new ArrayList<Integer>());
//            //rows
//            for (int j = 1; j < DataBase.data.get(i).size(); j++) {
//                mins.get(mins.size() - 1).set(mins.get(mins.size() - 1).size() - 1,Integer.parseInt(DataBase.data.get(j).get(i)));
//            }
//        }
//        System.out.println(FileProcessor.GetMinimum(mins.get(0)));
    }
}