module com.example.csc311_week6hw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csc311_week6hw to javafx.fxml;
    exports com.example.csc311_week6hw;
}