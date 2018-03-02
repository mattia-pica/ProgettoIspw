package Control;

import Boundary.LoginGUI;
import Boundary.PrenotationInterface;
import Boundary.ShowAule_Professore;
import Entity.Disponible_Room;
import Entity.Room;
import Entity.Secretary;
import Utils.*;
import DAO.*;
import Entity.Professore;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.ArrayList;

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

    public void show_p(LocalTime timeInizio, LocalTime timeFine, String dateSearch) {
        ArrayList<Disponible_Room> R;
        R = ShowDatabase_Prof.show_prof(timeInizio, timeFine, dateSearch);
        ShowAule_Professore showAule_professore = new ShowAule_Professore();
        for (Disponible_Room room : R){
            showAule_professore.parseRoom(room.getNome());

        }
    }

    public void show_p_complete() {
        ArrayList<Room> R;
        R = ShowCompleteDB_Prof.show_completeDB();
        PrenotationInterface pi = new PrenotationInterface();
        for (Room room : R) {
            pi.parseRoom(room.getNome(), room.getTipopr(), room.getDatapr(), room.getInizio(), room.getFine(), room.getFromp());
        }
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
