module com.example.lab06 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.lab06 to javafx.fxml;
    exports com.example.lab06;
}