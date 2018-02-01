package Control;

import DAO.DBInsert;
import DAO.LoginDB;
import DAO.ShowDatabase_Prof;
import DAO.ShowDatabase_Secr;
import Entity.Classroom_Professore;
import Entity.Classroom_Segretaria;
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
    public void secrInterface(String u, String p) throws IOException {
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Segretaria.fxml"));
        secondStage.setTitle("Hello World");
        secondStage.setScene(new Scene(root, 777, 490));
        secondStage.show();
    }

    public void profInterface(String u, String p) throws Exception{
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Professore.fxml"));
        thirdStage.setTitle("Hello World");
        thirdStage.setScene(new Scene(root, 777, 490));
        thirdStage.show();
    }

    public Controller show(ObservableList<Classroom_Segretaria> data, TableView tableUser, TableColumn columnStato, TableColumn columnName, TableColumn columnTipo, TableColumn columnData, TableColumn columnOra, TableColumn columnOra1, TableColumn columnFrom){
        ShowDatabase_Secr showDatabaseSecr = new ShowDatabase_Secr();
        showDatabaseSecr.show_secr(data, tableUser, columnStato, columnName, columnTipo, columnData, columnOra, columnOra1, columnFrom);
        return null;
    }

    public Controller show_p(ObservableList<Classroom_Professore> dataProf, TableView tableProf, TableColumn columnStatoProf, TableColumn columnNameProf, TableColumn columnTipoProf, TableColumn columnDataProf, TableColumn columnOraProf, TableColumn columnOra1Prof){

        ShowDatabase_Prof showDatabase_prof = new ShowDatabase_Prof();
        showDatabase_prof.show_prof(dataProf, tableProf, columnStatoProf, columnNameProf, columnTipoProf, columnDataProf, columnOraProf, columnOra1Prof);
        return null;
    }

    public Controller newP(String type, String type2, String a, String o, String o1, String d){
        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(type, type2, a, o, o1, d);
        return null;
    }
}
