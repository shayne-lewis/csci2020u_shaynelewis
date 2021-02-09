package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker birthField;
    public void handleSubmitButtonAction(ActionEvent actionEvent){
        actiontarget.setText("Registration complete.");
        System.out.println("Username: " + username.getText());
        System.out.println("Password: " + passwordField.getText());
        System.out.println("Full Name: " + nameField.getText());
        System.out.println("E-Mail: " + emailField.getText());
        System.out.println("Phone #: " + phoneField.getText());
        System.out.println("Date of Birth: " + birthField.getValue());
    }
}
