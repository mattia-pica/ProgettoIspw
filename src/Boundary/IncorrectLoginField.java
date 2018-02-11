package Boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IncorrectLoginField {

    @FXML
    private Label message;
    @FXML
    private Button btnTurnBack;

    public void turnToLogin(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
