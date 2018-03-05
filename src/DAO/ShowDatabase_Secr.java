package DAO;

import Entity.Professore;
import Entity.Room;
import Utils.ClassicSingleton;
import Utils.Classroom_Segretaria;
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

public class ShowDatabase_Secr {

    public static ArrayList<Room> show_secr() {

        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection3 = connection.connect_Aule();
        ArrayList<Room> Classrooms = new ArrayList<Room>();

        //-----------------MODIFICABILITÀ DELLE CELLE

        /*tableUser.setEditable(true);
        columnOra.setCellFactory(TextFieldTableCell.forTableColumn());
        columnData.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTipo.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStato.setCellFactory(TextFieldTableCell.forTableColumn());*/

        //---------------------------------------------

        try {

            ResultSet rs = connection3.createStatement().executeQuery("SELECT * FROM dbEsame.Aule");
            while (rs.next()) {
                Classrooms.add(new Room(rs.getString("Nome"), rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"), rs.getString("Fine"),
                        rs.getString("FromP")));
            }
            connection3.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        return Classrooms;

    }
}


