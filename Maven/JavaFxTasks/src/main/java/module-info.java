module lt.codeacademy.javafxtasks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens lt.codeacademy.javafxtasks to javafx.fxml;
    exports lt.codeacademy.javafxtasks;
}