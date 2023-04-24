module com.example.restaurantforusers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jbcrypt;

    opens com.example.restaurantforusers to javafx.fxml;
    exports com.example.restaurantforusers;
    exports com.example.restaurantforusers.dao;
    opens com.example.restaurantforusers.model to javafx.base;
    opens com.example.restaurantforusers.dao to javafx.fxml;
}