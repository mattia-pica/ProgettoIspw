package Boundary;

import Control.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginGUI {
    
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Button log;

    public void Login(ActionEvent actionEvent) {

        String u = user.getText().toString();
        String p = pass.getText().toString();

        Controller c = new Controller().check(u, p);

    }
}
