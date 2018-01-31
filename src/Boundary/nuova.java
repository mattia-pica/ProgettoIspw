package Boundary;

import Entity.Classroom;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import Control.Controller;

import java.time.format.DateTimeFormatter;

public class nuova {
    @FXML
    private TextField textAltro;
    @FXML
    private AnchorPane textOraFine;
    @FXML
    private Button btnLoad;
    @FXML
    private TextField textAule;
    @FXML
    private RadioButton rbSi;
    @FXML
    private RadioButton rbNo;
    @FXML
    private RadioButton rbEsame;
    @FXML
    private RadioButton rbConf;
    @FXML
    private DatePicker pickDate;
    @FXML
    private TextField textOraInizio;
    @FXML
    private Button btnConfirm;
    @FXML
    private TextField textOra1;
    @FXML
    private Label showMes;
    @FXML
    private RadioButton rbAltro;
    @FXML
    private TableColumn columnStato;
    @FXML
    private TableColumn columnName;
    @FXML
    private TableColumn columnTipo;
    @FXML
    private TableColumn columnData;
    @FXML
    private TableColumn columnOra;
    @FXML
    private TableColumn columnOra1;
    @FXML
    private ObservableList<Classroom> data;
    @FXML
    private javafx.scene.control.TableView<Classroom> tableUser;



    public void loadDataFromDatabase(ActionEvent actionEvent) {

        Controller c3 = new Controller();
        c3.show(data, tableUser,columnStato, columnName, columnTipo, columnData, columnOra, columnOra1);

    }

    public void newPrenotation(ActionEvent actionEvent) {

        if ((!rbAltro.isSelected()) && (textAule.getText().toString().isEmpty() || textOraInizio.getText().toString().isEmpty()
                || textOra1.getText().toString().isEmpty() || pickDate.getValue().equals(null))) {
            showMes.setVisible(true);

        }else {

            if (rbAltro.isSelected()){
                textAltro.setVisible(true);
            }

            String type = "Conf";
            String type2 = "No";
            if (rbEsame.isSelected()) type = "Esame";
            if (rbSi.isSelected()) type2 = "Si";
            String a = "Aula " + textAule.getText().toString();
            String o = textOraInizio.getText().toString();
            String o1 = textOra1.getText().toString();
            String d = pickDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Controller c4 = new Controller();
            c4.newP(type, type2, a, o, o1, d);
        }

    }

    public void altro(ActionEvent actionEvent) {

        textAltro.setVisible(true);
        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textAule.getText().toString().isEmpty() || textOraInizio.getText().toString().isEmpty()
                        || textOra1.getText().toString().isEmpty() || pickDate.getValue().equals(null)
                        || textAltro.getText().toString().isEmpty()) {
                    showMes.setVisible(true);
                } else {

                    String type = textAltro.getText().toString();
                    String type2 = "No";
                    //if (rbEsame.isSelected()) type = "Esame";
                    if (rbSi.isSelected()) type2 = "Si";
                    String a = "Aula " + textAule.getText().toString();
                    String o = textOraInizio.getText().toString();
                    String o1 = textOra1.getText().toString();
                    String d = pickDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Controller c4 = new Controller();
                    c4.newP(type, type2, a, o, o1, d);
                }
            }
        });
    }
}
