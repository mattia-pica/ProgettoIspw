package DAO;

import Entity.Classroom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowDatabase {

    public void show(ObservableList<Classroom> data, TableView tableUser, TableColumn columnStato, TableColumn columnName, TableColumn columnTipo, TableColumn columnData, TableColumn columnOra, TableColumn columnOra1){

        String query = "SELECT * FROM dati";

        //-----------------MODIFICABILITÀ DELLE CELLE

        /*tableUser.setEditable(true);
        columnOra.setCellFactory(TextFieldTableCell.forTableColumn());
        columnData.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTipo.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStato.setCellFactory(TextFieldTableCell.forTableColumn());*/

        //---------------------------------------------

        try {
            Connection conn = DBConnection.conn;
            data = FXCollections.observableArrayList();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                /*data.add(new UserDetails(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));*/
                data.add(new Classroom(rs.getString("Nome"), rs.getString("StatoPr"), rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"), rs.getString("Fine")));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnStato.setCellValueFactory(new PropertyValueFactory<>("stato"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnOra.setCellValueFactory(new PropertyValueFactory<>("ora"));
        columnOra1.setCellValueFactory(new PropertyValueFactory<>("ora1"));

        tableUser.setItems(null);
        tableUser.setItems(data);

    }

    }


