package Boundary;

import Entity.Classroom_Professore;
import Entity.Classroom_Segretaria;
import Entity.Professore;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Control.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.time.format.DateTimeFormatter;


public class ShowAule_Professore {
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
    private TextField textAltroProf;
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


    public void loadDataFromDBProf(ActionEvent actionEvent) {

        int InizioSearch = Integer.parseInt(oraInizioSearch.getText().toString());
        int FIneSearch = Integer.parseInt(oraFineSearch.getText().toString());
        int InizioSearch1 = Integer.parseInt(oraInizioSearch1.getText().toString());
        int FIneSearch1 = Integer.parseInt(oraFineSearch1.getText().toString());


        if ((InizioSearch+InizioSearch1) > (FIneSearch+FIneSearch1)){
            System.out.println("L'orario di fine è < di quello di inizio!!!");
        }

        String uno = oraInizioSearch.getText().toString() + ":" + oraInizioSearch1.getText().toString();
        String due = oraFineSearch.getText().toString() + ":" + oraFineSearch1.getText().toString();
        String dateSearch = datePickerSearch.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Controller c6 = new Controller();
        c6.show_p(dataProf, tableProf,  columnNameProf,  columnTipoProf,  columnDataProf,  columnOraProf,  columnOra1Prof, uno, due, dateSearch);
    }

    public void confirmPrenotation(ActionEvent actionEvent) {

        if ((!rbAltroProf.isSelected()) && (textAuleProf.getText().toString().isEmpty() ||
                textOraInizioProf.getText().toString().isEmpty()
                || textOra1Prof.getText().toString().isEmpty() || pickDateProf.getValue().equals(null))) {
            showMes.setVisible(true);

        }else {

            String type = "Conf";
            String type2 = "No";
            if (rbEsameProf.isSelected()) type = "Esame";
            //if (rbSiProf.isSelected()) type2 = "Si";
            String aP = "Aula " + textAuleProf.getText().toString();
            String oP = textOraInizioProf.getText().toString();
            String o1P = textOra1Prof.getText().toString();
            String dP = pickDateProf.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Controller c4 = new Controller();
            c4.newP(type, aP, oP, o1P, dP);
        }
    }

    public void altroProf(ActionEvent actionEvent) {

        /*textAltroProf.setVisible(true);
        btnConfirmProf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textAuleProf.getText().toString().isEmpty() || textOraInizioProf.getText().toString().isEmpty()
                        || textOra1Prof.getText().toString().isEmpty() || pickDateProf.getValue().equals(null)
                        || textAltroProf.getText().toString().isEmpty()) {
                    showMes.setVisible(true);
                } else {

                    String typeP = textAltroProf.getText().toString();
                    String type2P = "No";
                    //if (rbEsame.isSelected()) type = "Esame";
                    if (rbSiProf.isSelected()) type2P = "Si";
                    String aP = "Aula " + textAuleProf.getText().toString();
                    String oP = textOraInizioProf.getText().toString();
                    String o1P = textOra1Prof.getText().toString();
                    String dP = pickDateProf.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Controller c7 = new Controller();
                    c7.newPrenotation(typeP, type2P, aP, oP, o1P, dP);
                }
            }
        });*/
    }
}
