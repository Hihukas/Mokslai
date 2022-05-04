module lt.codeacademy.javafxtasktwo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens lt.codeacademy.javafxtasktwo to javafx.fxml;
    exports lt.codeacademy.javafxtasktwo;
}