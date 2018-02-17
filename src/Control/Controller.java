package Control;

import Boundary.LoginGUI;
import Entity.Secretary;
import Utils.*;
import DAO.*;
import Entity.Professore;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalTime;

public class Controller extends Application{

    //-------------------FXML LOADER-------------------//

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.start();
    }

    //--------------------Thread-----------------------//

    public Thread newThread() {

        Thread thread = new Thread(new CounterThread());
        thread.run();
        return thread;

    }

    //--------------ENTITY---------------------------//

    public Professore createEntityProfessore(String u, String p) {
        return new Professore(u, p);
    }

    public Secretary createEntitySecertary(String u, String p) {
        return new Secretary(u, p);
    }

    //--------------METODI GENERICI-------------------//

    public void createSingleton(String u, String p){
        ClassicSingleton singleton = ClassicSingleton.getInstance();
        Professore professore = check(u, p);
        singleton.setProfessore(professore);
    }



    public Professore check(String u, String p) {
        LoginDB loginDB = new LoginDB();
        Professore professore = loginDB.log(u, p);
        return professore;
    }

    public void show(ObservableList<Classroom_Segretaria> data, TableView tableSecretary,
                           TableColumn columnAulaSecretary, TableColumn columnTipoSecretary,
                           TableColumn columnDataSecretary, TableColumn columnInizioSecretary,
                           TableColumn columnFineSecretary, TableColumn columnFromSecretary) {
        ShowDatabase_Secr showDatabaseSecr = new ShowDatabase_Secr();
        showDatabaseSecr.show_secr(data, tableSecretary, columnAulaSecretary, columnTipoSecretary, columnDataSecretary,
                columnInizioSecretary, columnFineSecretary, columnFromSecretary);
    }

    public void show_p(ObservableList<Classroom_Professore> dataProf, TableView tableProf,
                             TableColumn columnNameProf, LocalTime timeInizio, LocalTime timeFine, String dateSearch) {
        ShowDatabase_Prof showDatabase_prof = new ShowDatabase_Prof();
        showDatabase_prof.show_prof(dataProf, tableProf, columnNameProf, timeInizio, timeFine, dateSearch);
    }

    public void show_p_complete(ObservableList<Classroom_ProfComplete> data, TableView tableProf,
                                      TableColumn columnNameProf, TableColumn columnTipoProf, TableColumn columnDataProf,
                                      TableColumn columnOraProf, TableColumn columnOra1Prof) {
        ShowCompleteDB_Prof showCompleteDB_prof = new ShowCompleteDB_Prof();
        showCompleteDB_prof.show_completeDB(data, tableProf, columnNameProf, columnDataProf, columnTipoProf,
                columnOraProf, columnOra1Prof);
    }

    public void newP(String nameAula, String tipoPrenota, String dataPrenota, LocalTime timeInizioPrenota,
                           LocalTime timeFinePrenota, boolean a) {
        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);
    }

    public void write(String nameAula, String tipoPrenota, LocalTime timeInizioPrenota, LocalTime timeFinePrenota,
                      String nameProf, String surnameProf) throws Exception {
        saveFileprenotation saveFileprenotation = new saveFileprenotation();
        saveFileprenotation.write(nameAula, tipoPrenota, timeInizioPrenota, timeFinePrenota, nameProf, surnameProf);
    }
}
