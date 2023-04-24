module com.example.restaurantformanagers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.restaurantformanagers to javafx.fxml;
    exports com.example.restaurantformanagers;
    exports com.example.restaurantformanagers.dao;
    opens com.example.restaurantformanagers.dao to javafx.fxml;
    opens com.example.restaurantformanagers.model to javafx.base;
}