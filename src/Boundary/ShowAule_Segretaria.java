package Boundary;

import Entity.Classroom_Segretaria;
import Entity.Professore;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Control.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowAule_Segretaria {

    @FXML
    private Button btnDelete;
    @FXML
    private TextField textAuleSecretary;
    @FXML
    private RadioButton rbSiSecretary;
    @FXML
    private ToggleGroup groupPrenotaInterface;
    @FXML
    private RadioButton rbNoSecretary;
    @FXML
    private RadioButton rbEsameSecretary;
    @FXML
    private ToggleGroup groupTipoInterface;
    @FXML
    private RadioButton rbConfSecretary;
    @FXML
    private DatePicker pickDateSecretary;
    @FXML
    private TextField InizioSecretary;
    @FXML
    private Button btnConfirmProf;
    @FXML
    private TextField fineSecretary;
    @FXML
    private Label showMes;
    @FXML
    private TextField altroSecretary;
    @FXML
    private TextField inizio1Secretary;
    @FXML
    private TextField fine1Secretary;
    @FXML
    private TableColumn columnAulaSecretary;
    @FXML
    private TableColumn columnTipoSecretary;
    @FXML
    private TableColumn columnDataSecretary;
    @FXML
    private TableColumn columnInizioSecretary;
    @FXML
    private TableColumn columnFineSecretary;
    @FXML
    private TableColumn columnFromSecretary;
    @FXML
    private Button btnSearch;
    @FXML
    private ObservableList<Classroom_Segretaria> data;
    @FXML
    private javafx.scene.control.TableView<Classroom_Segretaria> tableSecretary;


    public void loadDataFromDatabase(ActionEvent actionEvent) {

        Controller c3 = new Controller();
        c3.show(data, tableSecretary, columnAulaSecretary, columnTipoSecretary, columnDataSecretary, columnInizioSecretary, columnFineSecretary, columnFromSecretary);

    }

    public void newPrenotation(ActionEvent actionEvent/*, Professore professore*/){

        boolean a = true;

       if(textAuleSecretary.getText().toString().isEmpty() || InizioSecretary.getText().toString().isEmpty() ||
               inizio1Secretary.getText().toString().isEmpty() || fineSecretary.getText().toString().isEmpty()
               || fine1Secretary.getText().toString().isEmpty()){
           showMes.setVisible(true);
       }

       String nameAulaSec ="Aula " + textAuleSecretary.getText().toString();
       String dateSec = pickDateSecretary.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       String typeSec ="Conferenza";

       if (rbEsameSecretary.isSelected()) typeSec="Esame";

       /*int inizioSec = Integer.parseInt(InizioSecretary.getText().toString());
       int inizio1Sec = Integer.parseInt(inizio1Secretary.getText().toString());
       int fineSec = Integer.parseInt(fineSecretary.getText().toString());
       int fine1Sec = Integer.parseInt(fine1Secretary.getText().toString());*/

        String inizio = InizioSecretary.getText().toString() + ":" + inizio1Secretary.getText().toString();
        String fine = fineSecretary.getText().toString() + ":" + fine1Secretary.getText().toString();
        LocalTime timeInizioSec = LocalTime.parse(inizio);
        LocalTime timeFineSec = LocalTime.parse(fine);
        Controller c9 = new Controller();
        c9.newP(nameAulaSec, typeSec, dateSec, timeInizioSec, timeFineSec, a);
    }
}