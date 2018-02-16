package Control;

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

import java.io.IOException;
import java.time.LocalTime;

public class Controller extends Application {

    //-------------------FXML LOADER-------------------//

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/LoginGUI.fxml"));
        primaryStage.setTitle("Classroom");
        primaryStage.setScene(new Scene(root, 400, 205));
        primaryStage.show();
    }

    public void secrInterface(String u, String p) throws IOException {
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Segretaria.fxml"));
        secondStage.setTitle("Interface of " + u + "(secretary)");
        secondStage.setScene(new Scene(root, 600, 501));
        secondStage.setResizable(false);
        secondStage.show();
    }

    public void profInterface(String s, String u) throws Exception {
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Professore.fxml"));
        thirdStage.setTitle("Interface of " + s + " (professor)");
        thirdStage.setScene(new Scene(root, 488, 277));
        thirdStage.setResizable(false);
        thirdStage.show();
    }

    public void prenotationInterface() throws Exception {
        Stage fourthStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/prenotationInterface.fxml"));
        fourthStage.setTitle("Prenota Aula");
        fourthStage.setScene(new Scene(root, 678, 496));
        fourthStage.setResizable(false);
        fourthStage.show();
    }

    public void duplicateKeyMessage() throws Exception {

        Stage fifthStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/messageDuplicateKey.fxml"));
        fifthStage.setTitle("Prenota Aula");
        fifthStage.setScene(new Scene(root, 318, 123));
        fifthStage.setResizable(false);
        fifthStage.show();
    }

    public void incorrectLoginField() throws Exception {

        Stage sixthStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/loginIncorrect.fxml"));
        sixthStage.setScene(new Scene(root, 318, 123));
        sixthStage.setResizable(false);
        sixthStage.show();
    }

    public Thread newThread(){

        Thread thread = new Thread(new CounterThread());
        thread.run();
        return thread;

    }

    //--------------METODI GENERICI------------------//

    public Professore check(String u, String p) {
        LoginDB loginDB = new LoginDB();
        Professore professore = loginDB.log(u, p);
        return professore;
    }

    public Professore createEntityProfessore(String u, String p) {
        return new Professore(u, p);
    }

    public Secretary createEntitySecertary(String u, String p) {
        return new Secretary(u, p);
    }


    public Controller show(ObservableList<Classroom_Segretaria> data, TableView tableSecretary,
                           TableColumn columnAulaSecretary, TableColumn columnTipoSecretary,
                           TableColumn columnDataSecretary, TableColumn columnInizioSecretary,
                           TableColumn columnFineSecretary, TableColumn columnFromSecretary) {
        ShowDatabase_Secr showDatabaseSecr = new ShowDatabase_Secr();
        showDatabaseSecr.show_secr(data, tableSecretary, columnAulaSecretary, columnTipoSecretary, columnDataSecretary,
                columnInizioSecretary, columnFineSecretary, columnFromSecretary);
        return null;
    }

    public Controller show_p(ObservableList<Classroom_Professore> dataProf, TableView tableProf,
                             TableColumn columnNameProf, LocalTime timeInizio, LocalTime timeFine, String dateSearch) {
        ShowDatabase_Prof showDatabase_prof = new ShowDatabase_Prof();
        showDatabase_prof.show_prof(dataProf, tableProf, columnNameProf, timeInizio, timeFine, dateSearch);
        return null;
    }

    public Controller show_p_complete(ObservableList<Classroom_ProfComplete> data, TableView tableProf,
                                      TableColumn columnNameProf, TableColumn columnTipoProf, TableColumn columnDataProf,
                                      TableColumn columnOraProf, TableColumn columnOra1Prof) {
        ShowCompleteDB_Prof showCompleteDB_prof = new ShowCompleteDB_Prof();
        showCompleteDB_prof.show_completeDB(data, tableProf, columnNameProf, columnDataProf, columnTipoProf,
                columnOraProf, columnOra1Prof);
        return null;
    }

    public Controller newP(String nameAula, String tipoPrenota, String dataPrenota, LocalTime timeInizioPrenota,
                           LocalTime timeFinePrenota, boolean a) {
        DBInsert dbInsert = new DBInsert();
        dbInsert.insert(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);
        return null;
    }

    public void write(String nameAula, String tipoPrenota, LocalTime timeInizioPrenota, LocalTime timeFinePrenota,
                      String nameProf, String surnameProf) throws Exception {

        saveFileprenotation saveFileprenotation = new saveFileprenotation();
        saveFileprenotation.write(nameAula, tipoPrenota, timeInizioPrenota, timeFinePrenota, nameProf, surnameProf);
    }

}
