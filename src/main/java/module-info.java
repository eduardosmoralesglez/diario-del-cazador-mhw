module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    opens es.ies.puerto to javafx.fxml;

    exports es.ies.puerto;
    exports es.ies.puerto.controller;
    exports es.ies.puerto.model;
    exports es.ies.puerto.config;

    opens es.ies.puerto.controller to javafx.fxml;
    opens es.ies.puerto.model to com.fasterxml.jackson.databind,
            org.junit.platform.commons, org.mockito;
}