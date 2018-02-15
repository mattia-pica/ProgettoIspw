package DAO;

import Utils.ClassicSingleton;
import Utils.Classroom_ProfComplete;
import Entity.Professore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowCompleteDB_Prof {

    public void show_completeDB(ObservableList data, TableView tableProf, TableColumn columnNameProf,
                                TableColumn columnTipoProf, TableColumn columnDataProf, TableColumn columnOraProf, TableColumn columnOra1Prof){

        Professore professore = ClassicSingleton.getInstance().getProfessore();
        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection2 = connection.connect_Aule();

        String query ="SELECT Nome,TipoPr,DataPr,Inizio,Fine FROM dati WHERE Aule.dati.FromP='"+professore.getUsername()+"'";

        try {
            data = FXCollections.observableArrayList();
            Statement statement = connection2.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data.add(new Classroom_ProfComplete(rs.getString("Nome"),rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"),
                        rs.getString("Fine")));
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        columnNameProf.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnTipoProf.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDataProf.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnOraProf.setCellValueFactory(new PropertyValueFactory<>("ora"));
        columnOra1Prof.setCellValueFactory(new PropertyValueFactory<>("ora1"));

        tableProf.setItems(null);
        tableProf.setItems(data);

    }

}
