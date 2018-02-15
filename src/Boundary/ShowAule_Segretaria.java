package Boundary;

import Utils.Classroom_Segretaria;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Control.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowAule_Segretaria {

    @FXML
    private RadioButton rbAltroSecretary;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField textAuleSecretary;
    @FXML
    private ToggleGroup groupPrenotaInterface;
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

    public void newPrenotation(ActionEvent actionEvent){

        boolean a = true;
       String nameAulaSec ="Aula " + textAuleSecretary.getText().toString();
       String dateSec = pickDateSecretary.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       String inizio = InizioSecretary.getText().toString() + ":" + inizio1Secretary.getText().toString();
       String fine = fineSecretary.getText().toString() + ":" + fine1Secretary.getText().toString();
       String typeSec =null;

       if (rbEsameSecretary.isSelected()) {
           typeSec="Esame";
       }else if (rbConfSecretary.isSelected()){
           typeSec="Conferenza";
       }
       if(!rbEsameSecretary.isSelected() && !rbConfSecretary.isSelected()
               && !altroSecretary.getText().toString().isEmpty()){
           typeSec=altroSecretary.getText().toString();
       }

        if(textAuleSecretary.getText().toString().isEmpty() || InizioSecretary.getText().toString().isEmpty() ||
                inizio1Secretary.getText().toString().isEmpty() || fineSecretary.getText().toString().isEmpty()
                || fine1Secretary.getText().toString().isEmpty()){
            showMes.setVisible(true);
        }else {
            LocalTime timeInizioSec = LocalTime.parse(inizio);
            LocalTime timeFineSec = LocalTime.parse(fine);
            Controller c9 = new Controller();
            c9.newP(nameAulaSec, typeSec, dateSec, timeInizioSec, timeFineSec, a);
        }

       /*int inizioSec = Integer.parseInt(InizioSecretary.getText().toString());
       int inizio1Sec = Integer.parseInt(inizio1Secretary.getText().toString());
       int fineSec = Integer.parseInt(fineSecretary.getText().toString());
       int fine1Sec = Integer.parseInt(fine1Secretary.getText().toString());*/
    }
}