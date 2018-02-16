package Boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Duplicate_Key {

    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Button ok;

    public void duplicateKeyMessage() throws Exception {

        Stage fifthStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/messageDuplicateKey.fxml"));
        fifthStage.setTitle("Prenota Aula");
        fifthStage.setScene(new Scene(root, 318, 123));
        fifthStage.setResizable(false);
        fifthStage.show();
    }

    public void close(ActionEvent actionEvent) {

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
