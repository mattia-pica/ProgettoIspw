package DAO;

import Boundary.IncorrectLoginField;
import Boundary.ShowAule_Professore;
import Boundary.ShowAule_Segretaria;
import Control.Controller;
import Entity.Professore;
import Utils.ClassicSingleton;

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
                    System.out.println("Sei una segretaria, verrai reindirizzato fra 5 secondi");
                    Controller c1 = new Controller();
                    c1.createEntitySecertary(u, p);
                    c1.newThread();
                    ShowAule_Segretaria showAule_segretaria = new ShowAule_Segretaria();
                    showAule_segretaria.start();
                    break;
                case "0":
                    System.out.println("Sei un professore, verrai reindirizzato fra 5 secondi");
                    Controller c5 = new Controller();
                    professore = c5.createEntityProfessore(u, p);
                    c5.newThread();
                    ShowAule_Professore showAule_professore = new ShowAule_Professore();
                    showAule_professore.profInterface(u);
                    break;
                case "":
                default:
                    IncorrectLoginField incorrect = new IncorrectLoginField();
                    incorrect.incorrectLoginField();
                    System.out.print("Login field incorrect!");
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return professore;
    }
}

