module com.example.lab09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.lab09 to javafx.fxml;
    exports com.example.lab09;
}