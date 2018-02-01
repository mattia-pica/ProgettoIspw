package Boundary;

import Entity.Classroom_Professore;
import Entity.Classroom_Segretaria;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Control.Controller;


public class ShowAule_Professore {

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
    private TableColumn columnStatoProf;
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

        Controller c6 = new Controller();
        c6.show_p(dataProf, tableProf,  columnStatoProf,  columnNameProf,  columnTipoProf,  columnDataProf,  columnOraProf,  columnOra1Prof);


    }
}
