package DAO;

import Control.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDB {

    public LoginDB log(String u, String p) {

        DBConnection connection = new DBConnection();
        Connection conn = connection.connect();
        String QUERY = "SELECT Type FROM Users.users WHERE Username =" + "'" + u + "'" +
                "AND Password=" + "'" + p + "'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            String type = "";
            if (resultSet.next()) {
                type = resultSet.getString("Type");
                //System.out.println(type);
                //String firstName = resultSet.getString("Username");
                //System.out.println("Hi " + firstName +" You're logged in!");
                //System.out.println(resultSet.getString("Tipo"));
            } //else System.out.println("Login field incorrect!");
            switch (type) {
                case "1":
                    System.out.println("Sei una segretaria");
                    break;
                case "0":
                    System.out.println("Sei un professore");
                    Controller c1 = new Controller();
                    c1.profInterface(u, p);
                    break;

                case "":
                default:
                    System.out.print("Login field incorrect!");
            }
            /*if (type.equals("1")){
                System.out.println("Sei una segretaria");
            }else System.out.println("Sei un professore");

            System.out.println(type);*/
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return null;
    }
}

