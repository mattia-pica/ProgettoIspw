package Boundary;

import Utils.ClassicSingleton;
import Control.Controller;
import Entity.Professore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginGUI{

    @FXML
    private Button btnCancel;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;

    public void start() throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/LoginGUI.fxml"));
        primaryStage.setTitle("Classroom");
        primaryStage.setScene(new Scene(root, 400, 205));
        primaryStage.show();
    }

    public void Login(ActionEvent actionEvent){

        String u = user.getText().toString();
        String p = pass.getText().toString();

        Controller c = new Controller();
        c.createSingleton(u, p);
        /*ClassicSingleton singleton = ClassicSingleton.getInstance();
        Professore professore = c.check(u, p);
        singleton.setProfessore(professore);*/

    }

    public void emptyText(ActionEvent actionEvent) {
        user.setText(null);
        pass.setText(null);
    }
}
