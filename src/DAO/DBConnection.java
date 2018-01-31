package DAO;

import Control.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection conn;

    public Connection connect() {

        final String url = "jdbc:mysql://localhost:3306/Aule";
        final String user = "root";
        final String password = "trottola12";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                DBConnection.conn = DriverManager.getConnection(url, user, password);
                System.out.println("CONNESSO");
            } catch (Exception e) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
            return conn;  //NEL VIDEO retun null, ma così da problemi il controller che riceve null e non può andare avanti!
    }
}