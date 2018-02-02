package DAO;

import Entity.Classroom_Professore;
import Entity.Classroom_Segretaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.oracle.jrockit.jfr.Transition.From;

public class ShowDatabase_Prof {

    public void show_prof(ObservableList<Classroom_Professore> data, TableView tableProf, TableColumn columnStatoProf, TableColumn columnNameProf, TableColumn columnTipoProf, TableColumn columnDataProf, TableColumn columnOraProf, TableColumn columnOra1Prof, String u){

        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection2 = connection.connect_Aule();
        String query = "SELECT * FROM Aule.dati WHERE FromP='" + u + "'";

        try {
            //Connection conn = DB_Connection_Aule.conn_Aule;
            data = FXCollections.observableArrayList();
            Statement statement = connection2.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                /*data.add(new UserDetails(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));*/
                data.add(new Classroom_Professore(rs.getString("Nome"), rs.getString("StatoPr"), rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"), rs.getString("Fine")));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        columnNameProf.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnStatoProf.setCellValueFactory(new PropertyValueFactory<>("stato"));
        columnTipoProf.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDataProf.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnOraProf.setCellValueFactory(new PropertyValueFactory<>("ora"));
        columnOra1Prof.setCellValueFactory(new PropertyValueFactory<>("ora1"));



        tableProf.setItems(null);
        tableProf.setItems(data);


    }

}
