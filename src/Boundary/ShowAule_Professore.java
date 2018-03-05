package Boundary;

import Entity.Professore;
import Utils.ClassicSingleton;
import Utils.Classroom_ProfComplete;
import Utils.Classroom_Professore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

public class ShowAule_Professore {
    @FXML
    private Button Back;
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
    private javafx.scene.control.TableView<Classroom_Professore> table = new TableView<>();
    @FXML
    private TableColumn<Classroom_Professore, String> columnNome = new TableColumn<>("nome");
    @FXML
    private static ObservableList<Classroom_Professore> F = FXCollections.observableArrayList();
    @FXML
    private static String roomnome;


    public void profInterface(String profName) throws Exception {
        Stage thirdStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Boundary/Aule_Professore.fxml"));
        AnchorPane root = loader.load();
        thirdStage.setTitle("Interface of " + profName + "(professor)");
        Scene scene = new Scene(root, 436, 275);
        //thirdStage.setScene(new Scene(root, 488, 277));

        columnNome.setMinWidth(140);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        table.setPrefSize(140, 247);
        table.setLayoutX(10);
        table.setLayoutY(10);

        ((AnchorPane) scene.getRoot()).getChildren().addAll(table);
        table.setItems(F);
        table.getColumns().addAll(columnNome);
        thirdStage.setScene(scene);
        thirdStage.show();
    }

    public void parseRoom(String nome){
        roomnome=nome;
        F.add(new Classroom_Professore(roomnome));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        table.setItems(F);
    }

    public void loadDataFromDBProf(ActionEvent actionEvent) throws Exception{

        String c = "10/10/2010";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(c, formatter);
        datePickerSearch.setValue(localDate);

        /*int InizioSearch = Integer.parseInt(oraInizioSearch.getText().toString());
        int FIneSearch = Integer.parseInt(oraFineSearch.getText().toString());
        int InizioSearch1 = Integer.parseInt(oraInizioSearch1.getText().toString());
        int FIneSearch1 = Integer.parseInt(oraFineSearch1.getText().toString());

        if ((InizioSearch+InizioSearch1) > (FIneSearch+FIneSearch1)){
            System.out.println("L'orario di fine è < di quello di inizio!!!");
        }*/
        String uno = oraInizioSearch.getText().toString() + ":" + oraInizioSearch1.getText().toString();
        String due = oraFineSearch.getText().toString() + ":" + oraFineSearch1.getText().toString();
        String dateSearch = datePickerSearch.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if(uno.equals(":") || due.equals(":") || dateSearch.equals("10/10/2010")){

            Stage incompleteStage = new Stage();
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../Boundary/incompleteFields.fxml"));
            AnchorPane root = loader1.load();
            Scene scene = new Scene(root, 248, 142);
            incompleteStage.setScene(scene);
            incompleteStage.show();

        }else{
            LocalTime timeInizio = LocalTime.parse(uno);
            LocalTime timeFine = LocalTime.parse(due);
            Controller c6 = new Controller();
            c6.show_p(timeInizio, timeFine, dateSearch);
        }
    }
    public void newPrenotation(ActionEvent actionEvent) throws Exception {

        PrenotationInterface prenotation = new PrenotationInterface();
        prenotation.prenotationInterface();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void incorrect() throws Exception{

        Stage incompleteStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Boundary/incompleteFiedls.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 200, 200);

    }

    public void turnBack(ActionEvent actionEvent) {

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    }
}
