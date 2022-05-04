package lt.codeacademy.javafxtasks;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private Label helloLabel;

    @FXML
    protected void sayHello(){
        String name = nameField.getText();
        String surname = surnameField.getText();
        if(name == null || name.equals("") || surname == null || surname.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Laukeliai negali būti tušti!");
            alert.show();
        } else{
            nameField.setText("");
            surnameField.setText("");

            helloLabel.setText("Sveiki " + name + " " + surname);
        }
    }
}