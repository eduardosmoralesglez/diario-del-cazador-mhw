module mh {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens mh to javafx.fxml;

    exports mh;
    
    opens mh.backend.controller to javafx.fxml;
}
