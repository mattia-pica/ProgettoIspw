package Boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Control.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PrenotationInterface {

 /*   @FXML
    private Button dsfsdf;*/
    @FXML
    private Label showMes;
    @FXML
    private TextField textAuleProf;
    /*@FXML
    private RadioButton rbSiProf;
    @FXML
    private RadioButton rbNoProf;*/
    @FXML
    private RadioButton rbEsameProf;
    @FXML
    private RadioButton rbConfProf;
    @FXML
    private DatePicker pickDateProf;
    @FXML
    private TextField textOraInizioProf;
   /* @FXML
    private Button btnConfirmProf;*/
    @FXML
    private TextField textOra1Prof;
    @FXML
    private TextField textAltroProf;
    @FXML
    private TextField textOraInizioProf1;
    @FXML
    private TextField textOra1Prof1;
    /*@FXML
    private TableView tableProf;
    @FXML
    private TableColumn columnNameProf;
    @FXML
    private TableColumn columnTipoProf;
    @FXML
    private TableColumn columnDataProf;
    @FXML
    private TableColumn columnOraProf;
    @FXML
    private TableColumn columnOra1Prof;*/

    public void prenota(ActionEvent actionEvent) throws Exception {

        boolean a = false;
        String nameAula = "Aula " + textAuleProf.getText().toString();
        String dataPrenota = pickDateProf.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String inizioPrenota = textOraInizioProf.getText().toString() + ":" + textOraInizioProf1.getText().toString();
        String finePrenota = textOra1Prof.getText().toString() + ":" + textOra1Prof1.getText().toString();
        String tipoPrenota="";

        if(rbEsameProf.isSelected()) tipoPrenota = "Esame";
        else if (rbConfProf.isSelected()) tipoPrenota= "Conferenza";
        if (!rbEsameProf.isSelected() && !rbConfProf.isSelected() && !textAltroProf.getText().toString().isEmpty()){
            tipoPrenota = textAltroProf.getText().toString();}
        if(nameAula.isEmpty() || dataPrenota.isEmpty() || inizioPrenota.isEmpty()
                || finePrenota.isEmpty() || tipoPrenota.isEmpty()){
            showMes.setVisible(true);}
        LocalTime timeInizioPrenota = LocalTime.parse(inizioPrenota);
        LocalTime timeFinePrenota = LocalTime.parse(finePrenota);
        Controller c8 = new Controller();
        c8.newP(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);
    }
}
