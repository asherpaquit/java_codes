module com.example.demowat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demowat to javafx.fxml;
    exports com.example.demowat;
}