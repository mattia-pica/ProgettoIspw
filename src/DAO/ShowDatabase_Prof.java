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
import java.time.LocalTime;
import java.util.Date;

import static com.oracle.jrockit.jfr.Transition.From;

public class ShowDatabase_Prof {

    public void show_prof(ObservableList<Classroom_Professore> data, TableView tableProf, TableColumn columnNameProf,
                          TableColumn columnTipoProf, TableColumn columnDataProf, TableColumn columnOraProf, TableColumn columnOra1Prof,
                          LocalTime timeInizio, LocalTime timeFine, String dateSearch){

        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection2 = connection.connect_Aule();
        //String query = "SELECT * FROM dati WHERE dati.Nome NOT IN (SELECT Nome FROM dati WHERE DataPr='" + dateSearch + "'AND Inizio ='" + uno + "')";

        /*String query = "SELECT Nome FROM dati WHERE (DataPr='" + dateSearch + "' AND (('" + timeInizio +
                "' NOT BETWEEN Inizio AND Fine) AND ('" + timeFine + "' NOT BETWEEN Inizio AND Fine)))";*/

        String query ="SELECT DISTINCT Nome FROM dati WHERE Nome NOT IN (SELECT Nome FROM Aule.dati WHERE DataPr='"+dateSearch+"' AND ((Inizio<='"+timeInizio+"' AND Fine>='"+timeInizio+"') "+"OR (Fine>='"+timeFine+"' AND Inizio<='"+timeFine+"') "+"OR (Inizio>='"+timeInizio+"' AND Fine<='"+timeFine+"') "+"OR ((Inizio<='"+timeInizio+"' AND Fine>='"+timeInizio+"') AND (Fine>='"+timeFine+"' AND Inizio<='"+timeFine+"'))))";

        /*String query = "SELECT Nome, TipoPr,DataPr,Inizio,Fine FROM dati EXCEPT " +
                "(SELECT Nome,TipoPr,DataPr,Inizio,Fine FROM dati WHERE DataPr='" +
                dateSearch + "' AND Inizio='" + uno + "' AND Fine='" + due + "')";
*/
        try {
            //Connection conn = DB_Connection_Aule.conn_Aule;
            data = FXCollections.observableArrayList();
            Statement statement = connection2.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data.add(new Classroom_Professore(rs.getString("Nome")/*,rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"),
                        rs.getString("Fine")*/));
            }
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
