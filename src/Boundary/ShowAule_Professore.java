package Boundary;

import Entity.Classroom_Professore;
import Entity.Professore;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import Control.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
   /* @FXML
    private Button btnSearch;
    @FXML
    private Button btnLoadProf;
    @FXML
    private TextField textAuleProf;
    @FXML
    private RadioButton rbSiProf;
    @FXML
    private RadioButton rbNoProf;
    @FXML
    private RadioButton rbEsameProf;
    @FXML
    private ToggleGroup groupTipo;
    @FXML
    private RadioButton rbConfProf;
    @FXML
    private DatePicker pickDateProf;
    @FXML
    private TextField textOraInizioProf;
    @FXML
    private Button btnConfirmProf;
    @FXML
    private TextField textOra1Prof;
    @FXML
    private Label showMes;
    @FXML
    private RadioButton rbAltroProf;
    @FXML
    private TextField textAltroProf;*/
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
        c6.show_p(dataProf, tableProf,  columnNameProf,  columnTipoProf,  columnDataProf,  columnOraProf,  columnOra1Prof, timeInizio, timeFine, dateSearch);
    }
    public void newPrenotation(ActionEvent actionEvent) throws Exception {

        Controller c7 = new Controller();
        c7.prenotationInterface();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
