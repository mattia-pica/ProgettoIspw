package Control;

import DAO.*;
import Entity.Classroom_Professore;
import Entity.Classroom_Segretaria;
import Entity.Professore;
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
        secondStage.setTitle("Interface of " + u + "(secretary)");
        secondStage.setScene(new Scene(root, 777, 490));
        secondStage.setResizable(false);
        secondStage.show();
    }

    public void profInterface(String u, String p) throws Exception{
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Professore.fxml"));
        thirdStage.setTitle("Interface of " + u + "(professor)");
        thirdStage.setScene(new Scene(root, 679, 490));
        thirdStage.setResizable(false);
        thirdStage.show();
    }

    public void createEntityProfessore(String u, String p){
        Professore professore = new Professore(u, p);
    }

    /*public void newPrenotation(String typeP, String type2P, String aP, String oP, String o1P, String dP){
        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(typeP, type2P, aP, oP, o1P, dP);
    }*/

    public Controller show(ObservableList<Classroom_Segretaria> data, TableView tableUser, TableColumn columnStato, TableColumn columnName, TableColumn columnTipo, TableColumn columnData, TableColumn columnOra, TableColumn columnOra1, TableColumn columnFrom){
        ShowDatabase_Secr showDatabaseSecr = new ShowDatabase_Secr();
        showDatabaseSecr.show_secr(data, tableUser, columnTipo, columnData, columnOra, columnOra1, columnFrom);
        return null;
    }
    public Controller show_p(ObservableList<Classroom_Professore> dataProf, TableView tableProf,
                             TableColumn columnNameProf, TableColumn columnTipoProf, TableColumn columnDataProf,
                             TableColumn columnOraProf , TableColumn columnOra1Prof, String uno, String due, String dateSearch){
        ShowDatabase_Prof showDatabase_prof = new ShowDatabase_Prof();
        showDatabase_prof.show_prof(dataProf, tableProf, columnNameProf, columnTipoProf, columnDataProf, columnOraProf, columnOra1Prof, uno, due, dateSearch);
        return null;
    }

    public Controller newP(String type, String a, String o, String o1, String d){
        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(type, a, o, o1, d);
        return null;
    }
}
