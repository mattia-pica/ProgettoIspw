package DAO;

import java.sql.Statement;
import java.time.LocalTime;

import static DAO.DB_Connection_Aule.conn_Aule;

public class DBDelete {

    public void delete(String nameAula, String tipoPrenota, String dataPrenota, LocalTime timeInizioPrenota, LocalTime timeFinePrenota){

        String query = "DELETE FROM Aule.dati WHERE Nome='"+nameAula+"' AND ((DataPr='"+dataPrenota+"' AND Inizio<='"+timeInizioPrenota+"' AND Fine>='"+timeInizioPrenota+"')" +
                "OR (DataPr='"+dataPrenota+"' AND Fine>='"+timeFinePrenota+"' AND Inizio<='"+timeFinePrenota+"') " +
                "OR (DataPr='"+dataPrenota+"' AND Inizio>='"+timeInizioPrenota+"' AND Fine<='"+timeFinePrenota+"') " +
                "OR (DataPr='"+dataPrenota+"' AND Inizio<='"+timeInizioPrenota+"' AND Fine>='"+timeFinePrenota+"'))";

        try{
            DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
            db_connection_aule.connect_Aule();
            Statement statement = conn_Aule.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){

            System.err.println(e);

        }

    }

}
