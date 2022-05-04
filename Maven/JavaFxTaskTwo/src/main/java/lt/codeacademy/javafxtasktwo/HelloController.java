package lt.codeacademy.javafxtasktwo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {

    @FXML
    private TextField numberField;

    @FXML
    private Label randomNumber;

    @FXML
    private Label correctLabel;

    @FXML
    private Button randomButton;

    @FXML
    protected void setNumber() {
        Random random = new Random();
        int randomN = random.nextInt(10) + 1;
        try {
            int userNumber = Integer.parseInt(numberField.getText());

            if (userNumber == randomN) {
                randomNumber.setText("");
                correctLabel.setText("" + randomN);
                randomButton.setDisable(true);
            } else {
                randomNumber.setText("" + randomN);
            }
        } catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Įvestas ne skaičius");
            alert.show();
        }
    }
}