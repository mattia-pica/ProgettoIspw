package DAO;

import java.sql.Statement;

public class DBInsert extends DB_Connection_Aule {

    public void insert(String type, String type2, String a, String o, String o1, String d){

        String QUERY = "INSERT INTO Aule.dati (Nome, Statopr, TipoPr, DataPr, Inizio, Fine) VALUES " +
                "('" + a + "','" + type2 + "','" + type + "','" + d + "','" + o + "','" + o1 + "')";

        try{

            Statement statement = conn_Aule.createStatement();
            statement.executeUpdate(QUERY);
            //conn_Aule.close();

        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println("Exception:" + e.getMessage());
        }



    }

}
