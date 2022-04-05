package com.example.lab05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    static Stage mStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        mStage = stage;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static String OpenFileChooser(){
        FileChooser fileChooser = new FileChooser();
        File f = new File(String.valueOf(Paths.get("./")));
        fileChooser.setInitialDirectory(f);
        File selected = fileChooser.showOpenDialog(mStage);
        return selected.getName();
    }
    public static String SaveFileChooser(){
        FileChooser fileChooser = new FileChooser();
        File f = new File(String.valueOf(Paths.get("./")));
        fileChooser.setInitialDirectory(f);
        File selected = fileChooser.showSaveDialog(mStage);
        return selected.getName();
    }

    public static void main(String[] args) {
        launch();
    }
}