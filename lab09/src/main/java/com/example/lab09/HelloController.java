package com.example.lab09;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected LineChart<String, Float> lineChart;

    String GetStockPriceRaw(String stockSymbol) {
        String output = new String("");
        try {
            URL url = new URL("https://query1.finance.yahoo.com/v7/finance/download/" + stockSymbol + "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true ");
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(false);
            InputStream is = connection.getInputStream();
            output = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(output);
        return output;
    }

    ArrayList<ArrayList<String>> GetCSV(String raw) {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        String[] rows = raw.split("\n");

        for (String val :
                rows) {
            String[] cells = val.split(",");
            ArrayList<String> columns = new ArrayList<>();
            for (String cell :
                    cells) {
                columns.add(cell);
            }
            data.add(columns);
        }

        return data;
    }

    ArrayList<ArrayList<String>> GetStockPriceCSV(String symbol) {
        return GetCSV(GetStockPriceRaw(symbol));
    }

    ArrayList<Float> GetClosingPrices(String symbol) {
        ArrayList<Float> output = new ArrayList<>();

        var data = GetStockPriceCSV(symbol);
        for (int i = 0; i < data.size(); i++) {
            if (i == 0)
                continue;
            output.add(Float.parseFloat(data.get(i).get(4)));
        }
        return output;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> dates = new ArrayList<>();

        {
            var tData = GetStockPriceCSV("GOOG");
            int i = 0;

            for (var row :
                    tData) {
                if (i == 0) {
                    i++;
                    continue;
                }
                dates.add(row.get(0));
            }
        }
        var apple = GetClosingPrices("AAPL");
        var msft = GetClosingPrices("MSFT");
        XYChart.Series<String, Float> stock1 = new XYChart.Series<String, Float>();
        XYChart.Series<String, Float> stock2 = new XYChart.Series<String, Float>();
        stock1.setName("Apple");
        stock2.setName("Microsoft");
        for (int i = 0; i < dates.size(); i++) {
            stock1.getData().add(new XYChart.Data<>(dates.get(i), apple.get(i)));
            stock2.getData().add(new XYChart.Data<>(dates.get(i), msft.get(i)));
        }
        lineChart.setTitle("Apple vs. Microsoft");
        lineChart.getData().addAll(stock1,stock2);
    }
}