package DAO;

import java.sql.Statement;

public class DBInsert extends DBConnection{

    public void insert(String type, String type2, String a, String o, String o1, String d){

        String QUERY = "INSERT INTO Aule.dati (Nome, Statopr, TipoPr, DataPr, Inizio, Fine) VALUES " +
                "('" + a + "','" + type2 + "','" + type + "','" + d + "','" + o + "','" + o1 + "')";

        try{

            Statement statement = conn.createStatement();
            statement.executeUpdate(QUERY);
            //conn.close();

        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println("Exception:" + e.getMessage());
        }



    }

}
