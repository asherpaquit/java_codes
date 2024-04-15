module com.example.perfectnumber_paquit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.perfectnumber_paquit to javafx.fxml;
    exports com.example.perfectnumber_paquit;
}