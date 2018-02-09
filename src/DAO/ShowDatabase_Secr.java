package DAO;

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

public class ShowDatabase_Secr {

    public void show_secr(ObservableList<Classroom_Segretaria> data, TableView tableSecretary, TableColumn columnAulaSecretary, TableColumn columnTipoSecretary, TableColumn columnDataSecretary, TableColumn columnInizioSecretary, TableColumn columnFineSecretary, TableColumn columnFromSecretary){


        DB_Connection_Aule connection = new DB_Connection_Aule();
        Connection connection1 = connection.connect_Aule();
        String query = "SELECT * FROM Aule.dati";

        //-----------------MODIFICABILITÀ DELLE CELLE

        /*tableUser.setEditable(true);
        columnOra.setCellFactory(TextFieldTableCell.forTableColumn());
        columnData.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTipo.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStato.setCellFactory(TextFieldTableCell.forTableColumn());*/

        //---------------------------------------------

        try {
            //Connection conn = DB_Connection_Aule.conn_Aule;
            data = FXCollections.observableArrayList();
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                /*data.add(new Classroom_Segretaria(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));*/
                data.add(new Classroom_Segretaria(rs.getString("Nome"), rs.getString("TipoPr"),
                        rs.getString("DataPr"), rs.getString("Inizio"), rs.getString("Fine"),
                        rs.getString("FromP")));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        columnAulaSecretary.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnTipoSecretary.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDataSecretary.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnInizioSecretary.setCellValueFactory(new PropertyValueFactory<>("ora"));
        columnFineSecretary.setCellValueFactory(new PropertyValueFactory<>("ora1"));
        columnFromSecretary.setCellValueFactory(new PropertyValueFactory<>("from"));


        tableSecretary.setItems(null);
        tableSecretary.setItems(data);
    }

    }


