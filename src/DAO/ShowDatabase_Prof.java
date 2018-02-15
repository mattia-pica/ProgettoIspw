package DAO;

import Utils.Classroom_Professore;
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

public class ShowDatabase_Prof {

    public void show_prof(ObservableList<Classroom_Professore> data, TableView tableProf, TableColumn columnNameProf,
                          LocalTime timeInizio, LocalTime timeFine, String dateSearch){

        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection2 = connection.connect_Aule();
        String query ="SELECT DISTINCT Nome FROM dati WHERE Nome NOT IN (SELECT Nome FROM Aule.dati WHERE DataPr='"
                +dateSearch+"' AND ((Inizio<='"+timeInizio+"' AND Fine>='"+timeInizio+"') "+"OR (Fine>='"+timeFine
                +"' AND Inizio<='"+timeFine+"') "+"OR (Inizio>='"+timeInizio+"' AND Fine<='"+timeFine+"') "+
                "OR ((Inizio<='"+timeInizio+"' AND Fine>='"+timeInizio+"') AND (Fine>='"+timeFine+"' AND Inizio<='"
                +timeFine+"'))))";
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
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        columnNameProf.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableProf.setItems(null);
        tableProf.setItems(data);
    }
}
