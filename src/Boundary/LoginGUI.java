package Boundary;

import Utils.ClassicSingleton;
import Control.Controller;
import Entity.Professore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginGUI {

    @FXML
    private Button btnCancel;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;

    public void Login(ActionEvent actionEvent){

        String u = user.getText().toString();
        String p = pass.getText().toString();

        ClassicSingleton singleton = ClassicSingleton.getInstance();
        Controller c = new Controller();
        Professore professore = c.check(u, p);
        singleton.setProfessore(professore);

    }

    public void emptyText(ActionEvent actionEvent) {
        user.setText(null);
        pass.setText(null);
    }
}
