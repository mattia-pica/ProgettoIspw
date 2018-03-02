package DAO;

import Entity.Disponible_Room;
import Entity.Room;
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
import java.util.ArrayList;

public class ShowDatabase_Prof {

    public static ArrayList<Disponible_Room> show_prof(LocalTime timeInizio, LocalTime timeFine, String dateSearch){

        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection1 = connection.connect_Aule();
        ArrayList<Disponible_Room> Classrooms = new ArrayList<Disponible_Room>();

        String query ="SELECT DISTINCT nome FROM Aule WHERE nome NOT IN (SELECT nome FROM Aule.dati WHERE datapr='"
                +dateSearch+"' AND ((inizio<='"+timeInizio+"' AND fine>='"+timeInizio+"') "+"OR (fine>='"+timeFine
                +"' AND inizio<='"+timeFine+"') "+"OR (inizio>='"+timeInizio+"' AND fine<='"+timeFine+"') "+
                "OR ((inizio<='"+timeInizio+"' AND fine>='"+timeInizio+"') AND (fine>='"+timeFine+"' AND inizio<='"
                +timeFine+"'))))";
        try {
            //Connection conn = DB_Connection_Aule.conn_Aule;
            ResultSet rs = connection1.createStatement().executeQuery(query);
            while (rs.next()) {
                Classrooms.add(new Disponible_Room(rs.getString(1)/*, rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)*/));
            }
            connection1.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return Classrooms;
    }
}
