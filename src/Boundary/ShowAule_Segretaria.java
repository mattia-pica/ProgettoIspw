package Boundary;

import Utils.Classroom_ProfComplete;
import Utils.Classroom_Professore;
import Utils.Classroom_Segretaria;
import javafx.application.Application;
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

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowAule_Segretaria{

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
    private Button btnSearch;
    @FXML
    private javafx.scene.control.TableView<Classroom_Segretaria> table = new TableView<>();
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnNome = new TableColumn<>("nome");
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnTipoPr = new TableColumn<>("tipopr");
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnDataPr = new TableColumn<>("datapr");
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnInizio = new TableColumn<>("inizio");
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnFine = new TableColumn<>("fine");
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnFromP = new TableColumn<>("fromp");
    @FXML
    private static ObservableList<Classroom_Segretaria> S = FXCollections.observableArrayList();

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

    public void start() throws Exception {

        Stage secondStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Boundary/Aule_Segretaria.fxml"));
        AnchorPane root = loader.load();
        secondStage.setTitle("Interface of (secretary)");
        Scene scene = new Scene(root, 800, 501);


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

        columnFromP.setMinWidth(130);
        columnFromP.setCellValueFactory(new PropertyValueFactory<>("fromp"));

        table.setItems(S);
        table.setPrefSize(780, 223);
        table.setLayoutY(10);
        table.setLayoutX(10);
        table.getColumns().addAll(columnNome, columnTipoPr, columnDataPr, columnInizio, columnFine, columnFromP);
        ((AnchorPane) scene.getRoot()).getChildren().addAll(table);


        secondStage.setScene(scene);
        secondStage.setResizable(false);
        secondStage.show();

    }

    public void parseRoom(String nome, String tipopr, String datapr, String inizio, String fine, String fromp){
        roomnome = nome;
        roomtipopr = tipopr;
        roomdatapr = datapr;
        roominizio = inizio;
        roomfine = fine;
        roomfromp = fromp;

        S.add(new Classroom_Segretaria(roomnome, roomtipopr, roomdatapr, roominizio, roomfine, roomfromp));

        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnTipoPr.setCellValueFactory(new PropertyValueFactory<>("tipopr"));
        columnDataPr.setCellValueFactory(new PropertyValueFactory<>("datapr"));
        columnInizio.setCellValueFactory(new PropertyValueFactory<>("inizio"));
        columnFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        columnFromP.setCellValueFactory(new PropertyValueFactory<>("fromp"));
        table.setItems(S);
    }

    public void loadDataFromDatabase(ActionEvent actionEvent) {

        Controller c3 = new Controller();
        c3.show();
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
