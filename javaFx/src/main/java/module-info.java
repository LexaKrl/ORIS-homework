module com.kirilin.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires json.simple;
    requires org.json;


    opens com.kirilin.javafx to javafx.fxml;
    exports com.kirilin.javafx.weather;
    opens com.kirilin.javafx.weather to javafx.fxml;
    exports com.kirilin.javafx.weather.controller;
    opens com.kirilin.javafx.weather.controller to javafx.fxml;
}