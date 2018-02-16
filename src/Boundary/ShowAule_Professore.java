package Boundary;

import Entity.Professore;
import Utils.ClassicSingleton;
import Utils.Classroom_Professore;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import Control.Controller;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowAule_Professore {
    @FXML
    private TextField textOraInizioProf1;
    @FXML
    private TextField textOra1Prof1;
    @FXML
    private TextField oraInizioSearch1;
    @FXML
    private TextField oraFineSearch1;
    @FXML
    private DatePicker datePickerSearch;
    @FXML
    private TextField oraInizioSearch;
    @FXML
    private TextField oraFineSearch;
    @FXML
    private TableColumn columnNameProf;
    @FXML
    private TableColumn columnTipoProf;
    @FXML
    private TableColumn columnDataProf;
    @FXML
    private TableColumn columnOraProf;
    @FXML
    private TableColumn columnOra1Prof;
    @FXML
    private ObservableList<Classroom_Professore> dataProf;
    @FXML
    private javafx.scene.control.TableView<Classroom_Professore> tableProf;

    public void profInterface(String profName) throws Exception {
        Stage thirdStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Boundary/Aule_Professore.fxml"));
        thirdStage.setTitle("Interface of" + profName + "(professor)");
        thirdStage.setScene(new Scene(root, 488, 277));
        thirdStage.setResizable(false);
        thirdStage.show();
    }

    public void loadDataFromDBProf(ActionEvent actionEvent){

        int InizioSearch = Integer.parseInt(oraInizioSearch.getText().toString());
        int FIneSearch = Integer.parseInt(oraFineSearch.getText().toString());
        int InizioSearch1 = Integer.parseInt(oraInizioSearch1.getText().toString());
        int FIneSearch1 = Integer.parseInt(oraFineSearch1.getText().toString());

        if ((InizioSearch+InizioSearch1) > (FIneSearch+FIneSearch1)){
            System.out.println("L'orario di fine è < di quello di inizio!!!");
        }
        String uno = oraInizioSearch.getText().toString() + ":" + oraInizioSearch1.getText().toString() + ":00";
        String due = oraFineSearch.getText().toString() + ":" + oraFineSearch1.getText().toString() + ":00";
        String dateSearch = datePickerSearch.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalTime timeInizio = LocalTime.parse(uno);
        LocalTime timeFine = LocalTime.parse(due);

       /* DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date timeInizio = sdf.parse(uno);
        Date timeFine = sdf.parse(due);*/

        Controller c6 = new Controller();
        c6.show_p(dataProf, tableProf,  columnNameProf, timeInizio, timeFine, dateSearch);
    }
    public void newPrenotation(ActionEvent actionEvent) throws Exception {

        PrenotationInterface prenotation = new PrenotationInterface();
        prenotation.prenotationInterface();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
