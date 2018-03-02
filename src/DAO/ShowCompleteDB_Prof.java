package DAO;

import Entity.Room;
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
import java.util.ArrayList;

public class ShowCompleteDB_Prof {

    public static ArrayList<Room> show_completeDB(){

        Professore professore = ClassicSingleton.getInstance().getProfessore();
        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection2 = connection.connect_Aule();
        ArrayList<Room> Classrooms = new ArrayList<Room>();

        //String query ="SELECT Nome,TipoPr,DataPr,Inizio,Fine FROM dati WHERE Aule.dati.FromP='"+professore.getUsername()+"'";

        try {
            ResultSet rs = connection2.createStatement().executeQuery("SELECT * FROM dbEsame.Aule WHERE fromp='"+
            professore.getUsername() + "'");
            /*data = FXCollections.observableArrayList();
            Statement statement = connection2.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data.add(new Classroom_ProfComplete(rs.getString("Nome"),rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"),
                        rs.getString("Fine")));*/
            while (rs.next()){
                Classrooms.add(new Room(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            connection2.close();
            }catch (SQLException e) {
            System.err.println("Error" + e);
        }

        return Classrooms;
    }

}
