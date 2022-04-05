package com.example.lab05;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.apache.commons.csv.*;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn<StudentRecord, String> SID;
    @FXML
    private TableColumn<StudentRecord, String> MID;
    @FXML
    private TableColumn<StudentRecord, String> ASI;
    @FXML
    private TableColumn<StudentRecord, String> EXA;
    @FXML
    private TableColumn<StudentRecord, String> MAR;
    @FXML
    private TableColumn<StudentRecord, String> LET;
    @FXML
    private TableView view;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void SaveAs() {
        currentFileName = HelloApplication.SaveFileChooser();
        Save();
    }

    @FXML
    protected void Save() {

        try {
            if (!currentFileName.contains(".csv"))
                currentFileName += ".csv";
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("./" + currentFileName));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("StudentID", "Midterm", "Assignments", "Finalexam"));
            for (StudentRecord record :
                    DataSource.getAllMarks()) {
                csvPrinter.printRecord(record.getStudentID(), record.getMidterm(), record.getAssignments(), record.getFinalexam());
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void Load() {
        currentFileName = HelloApplication.OpenFileChooser();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("./" + currentFileName));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase());
            DataSource.currentData.clear();
            for (CSVRecord record :
                    csvParser) {
                float mid = Float.parseFloat(record.get("Midterm"));
                float asi = Float.parseFloat(record.get("Assignments"));
                float fin = Float.parseFloat(record.get("Finalexam"));
                StudentRecord nRecord = new StudentRecord(record.get("StudentID"), mid, asi, fin);
                DataSource.currentData.add(nRecord);
            }
            view.setItems(DataSource.currentData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void New() {
        DataSource.currentData.clear();
        view.setItems(DataSource.currentData);
    }

    @FXML
    protected void Exit() {
        Platform.exit();
    }

    String currentFileName = "hi.csv";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("StudentID"));
        MID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("Midterm"));
        ASI.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("Assignments"));
        EXA.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("Finalexam"));
        MAR.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("FinalMark"));
        LET.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("LetterGrade"));

        view.setItems(DataSource.getAllMarks());
    }
}