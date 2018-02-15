package DAO;

import Control.Controller;
import Entity.Professore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDB {

    public Professore log(String u, String p) {

        Professore professore = null;

        DB_Connection_Users connection = new DB_Connection_Users();
        Connection conn = connection.connect_Users();
        String QUERY = "SELECT Type FROM Users.users WHERE Username =" + "'" + u + "'" +
                "AND Password=" + "'" + p + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            String type = "";
            if (resultSet.next()) {
                type = resultSet.getString("Type");
                statement.close();
            }
            switch (type) {
                case "1":
                    System.out.println("Sei una segretaria");
                    Controller c1 = new Controller();
                    c1.createEntitySecertary(u, p);
                    c1.secrInterface(u, p);
                    break;
                case "0":
                    System.out.println("Sei un professore");
                    Controller c5 = new Controller();
                    professore = c5.createEntityProfessore(u, p);
                    c5.profInterface(u, p);
                    break;
                case "":
                default:
                    Controller c12 = new Controller();
                    c12.incorrectLoginField();
                    System.out.print("Login field incorrect!");
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return professore;
    }
}

