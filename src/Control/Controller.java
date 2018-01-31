package Control;

import DAO.DBInsert;
import DAO.LoginDB;
import DAO.ShowDatabase;
import Entity.Classroom;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/LoginGUI.fxml"));
        primaryStage.setTitle("ASDERELLE");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public Controller check(String u, String p){
        LoginDB loginDB = new LoginDB().log(u, p);
        return null;
    }

    public void profInterface(String u, String p) throws IOException {
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/nuova.fxml"));
        secondStage.setTitle("Hello World");
        secondStage.setScene(new Scene(root, 663, 490));
        secondStage.show();
    }

    public Controller show(ObservableList<Classroom> data, TableView tableUser, TableColumn columnStato, TableColumn columnName, TableColumn columnTipo, TableColumn columnData, TableColumn columnOra, TableColumn columnOra1){

        ShowDatabase showDatabase = new ShowDatabase();
        showDatabase.show(data, tableUser, columnStato, columnName, columnTipo, columnData, columnOra, columnOra1);
        return null;
    }

    public Controller newP(String type, String type2, String a, String o, String o1, String d){

        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(type, type2, a, o, o1, d);
        return null;
    }

}
