module lab04 {
    requires javafx.controls;
    requires javafx.fxml;

    opens lab04 to javafx.fxml;
    exports lab04;
}
