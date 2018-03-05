package Boundary;

import Utils.Classroom_ProfComplete;
import Utils.Classroom_Professore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import Control.Controller;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PrenotationInterface {

    @FXML
    private RadioButton rbAltroProf;
    @FXML
    private Label showMes;
    @FXML
    private TextField textAuleProf;
    @FXML
    private RadioButton rbEsameProf;
    @FXML
    private RadioButton rbConfProf;
    @FXML
    private DatePicker pickDateProf;
    @FXML
    private TextField textOraInizioProf;
    @FXML
    private TextField textOra1Prof;
    @FXML
    private TextField textAltroProf;
    @FXML
    private TextField textOraInizioProf1;
    @FXML
    private TextField textOra1Prof1;
    @FXML
    private javafx.scene.control.TableView<Classroom_ProfComplete> table = new TableView<>();
    @FXML
    private TableColumn<Classroom_ProfComplete, String> columnNome = new TableColumn<>("nome");
    @FXML
    private TableColumn<Classroom_ProfComplete, String> columnTipoPr = new TableColumn<>("tipopr");
    @FXML
    private TableColumn<Classroom_ProfComplete, String> columnDataPr = new TableColumn<>("datapr");
    @FXML
    private TableColumn<Classroom_ProfComplete, String> columnInizio = new TableColumn<>("inizio");
    @FXML
    private TableColumn<Classroom_ProfComplete, String> columnFine = new TableColumn<>("fine");
    /*@FXML
    private TableColumn<Classroom_ProfComplete, String> columnFromP = new TableColumn<>("fromp");*/
    @FXML
    private static ObservableList<Classroom_ProfComplete> D = FXCollections.observableArrayList();
    @FXML
    private static String roomnome;
    @FXML
    private static String roomtipopr;
    @FXML
    private static String roomdatapr;
    @FXML
    private static String roominizio;
    @FXML
    private static String roomfine;
    @FXML
    private static String roomfromp;

    public void prenotationInterface() throws Exception {
        Stage fourthStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Boundary/prenotationInterface.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 678, 496);

        columnNome.setMinWidth(130);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        columnTipoPr.setMinWidth(130);
        columnTipoPr.setCellValueFactory(new PropertyValueFactory<>("tipopr"));

        columnDataPr.setMinWidth(130);
        columnDataPr.setCellValueFactory(new PropertyValueFactory<>("datapr"));

        columnInizio.setMinWidth(130);
        columnInizio.setCellValueFactory(new PropertyValueFactory<>("inizio"));

        columnFine.setMinWidth(130);
        columnFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        /*columnFromP.setMinWidth(150);
        columnFromP.setCellValueFactory(new PropertyValueFactory<>("fromp"));*/

        table.setItems(D);
        table.setPrefSize(661, 223);
        table.setLayoutY(10);
        table.setLayoutX(10);
        table.getColumns().addAll(columnNome, columnTipoPr, columnDataPr, columnInizio, columnFine/*, columnFromP*/);
        ((AnchorPane) scene.getRoot()).getChildren().addAll(table);

        fourthStage.setScene(scene);
       // fourthStage.setResizable(false);
        fourthStage.show();
    }

    public void parseRoom(String nome, String tipopr, String datapr, String inizio, String fine, String fromp){
        roomnome = nome;
        roomtipopr = tipopr;
        roomdatapr = datapr;
        roominizio = inizio;
        roomfine = fine;
        roomfromp = fromp;

        D.add(new Classroom_ProfComplete(roomnome, roomtipopr, roomdatapr, roominizio, roomfine, roomfromp));

        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnTipoPr.setCellValueFactory(new PropertyValueFactory<>("tipopr"));
        columnDataPr.setCellValueFactory(new PropertyValueFactory<>("datapr"));
        columnInizio.setCellValueFactory(new PropertyValueFactory<>("inizio"));
        columnFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        //columnFromP.setCellValueFactory(new PropertyValueFactory<>("fromp"));
        table.setItems(D);
    }

    public void prenota(ActionEvent actionEvent){

        boolean a = false;
        String nameAula = "Aula " + textAuleProf.getText().toString();
        String c = "10/10/2010";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(c, formatter);
        pickDateProf.setValue(localDate);

        String dataPrenota = pickDateProf.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dataPrenota);
        String inizioPrenota = textOraInizioProf.getText().toString() + ":" + textOraInizioProf1.getText().toString();
        String finePrenota = textOra1Prof.getText().toString() + ":" + textOra1Prof1.getText().toString();
        String tipoPrenota="";

        if(rbEsameProf.isSelected()) tipoPrenota = "Esame";
        else if (rbConfProf.isSelected()) tipoPrenota= "Conferenza";
        if (!rbEsameProf.isSelected() && !rbConfProf.isSelected() && !textAltroProf.getText().toString().isEmpty()){
            tipoPrenota = textAltroProf.getText().toString();}
        if (rbAltroProf.isSelected()){
            tipoPrenota=textAltroProf.getText().toString();
        }
        if(nameAula.equals("Aula") || dataPrenota.equals("10/10/2010") || inizioPrenota.equals(":") || finePrenota.equals(":") || tipoPrenota.equals(null)) {
            showMes.setVisible(true);
        }else {
            LocalTime timeInizioPrenota = LocalTime.parse(inizioPrenota);
            LocalTime timeFinePrenota = LocalTime.parse(finePrenota);
            Controller c8 = new Controller();
            c8.newP(nameAula, tipoPrenota, dataPrenota, timeInizioPrenota, timeFinePrenota, a);
        }
    }

    public void show_complete_prof(ActionEvent actionEvent) {

        Controller controller = new Controller();
        controller.show_p_complete();

    }
}
