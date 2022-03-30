module com.assignment.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.assignment.assignment2 to javafx.fxml;
    exports com.assignment.assignment2;
}