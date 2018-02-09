package Boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Duplicate_Key {

    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Button ok;

    public void close(ActionEvent actionEvent) {

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
