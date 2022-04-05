package com.example.lab05;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn<StudentRecord,String> SID;
    @FXML
    private TableColumn<StudentRecord,String> MID;
    @FXML
    private TableColumn<StudentRecord,String> ASI;
    @FXML
    private TableColumn<StudentRecord,String> EXA;
    @FXML
    private TableColumn<StudentRecord,String> MAR;
    @FXML
    private TableColumn<StudentRecord,String> LET;
    @FXML
    private TableView view;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SID.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("StudentID"));
        MID.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("Midterm"));
        ASI.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("Assignments"));
        EXA.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("Finalexam"));
        MAR.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("FinalMark"));
        LET.setCellValueFactory(new PropertyValueFactory<StudentRecord,String>("LetterGrade"));

        view.setItems(DataSource.getAllMarks());
    }
}