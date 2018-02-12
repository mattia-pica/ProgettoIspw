package DAO;

import Utils.ClassicSingleton;
import Control.Controller;
import Entity.Professore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;


import static DAO.DB_Connection_Users.conn_Users;


public class DBInsert extends DB_Connection_Aule {

    public void insert(String nameAula, String tipoPrenota, String dataPrenota, LocalTime timeInizioPrenota,
                       LocalTime timeFinePrenota, boolean a) {



        //---------------------PROFESSORE------------------//

        if (!a) {
            try {
                String controlQuery = "SELECT Nome FROM Aule.dati WHERE Nome='" + nameAula + "' AND((DataPr='" + dataPrenota
                        + "' AND Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "')"
                        + "OR(DataPr='" + dataPrenota + "' AND Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " +
                        "OR(DataPr='" + dataPrenota + "' AND Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "')"
                        + "OR(DataPr='" + dataPrenota + "'AND Inizio<='" + timeInizioPrenota + "'AND Fine>='" + timeFinePrenota + "'))";
                DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                db_connection_aule.connect_Aule();
                Statement statement = conn_Aule.createStatement();
                ResultSet rs = statement.executeQuery(controlQuery);
                if (rs.next()) {
                    Controller c9 = new Controller();
                    c9.duplicateKeyMessage();
                } else {
                    Professore professore = ClassicSingleton.getInstance().getProfessore();

                    String QUERYprof = "INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) VALUES " + "('"
                            + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','" + timeInizioPrenota +
                            "','" + timeFinePrenota + "','" + professore.getUsername() + "')";
                    DB_Connection_Aule db_connection_aule1 = new DB_Connection_Aule();
                    db_connection_aule1.connect_Aule();
                    statement.executeUpdate(QUERYprof);


                    //-----------STAMPA FILE CON DATI PRENOTAZIONE-------------\\


                    String nameProf="";
                    String surnameProf ="";

                    String getProfName = "SELECT users.Name FROM users WHERE Username='" + professore.getUsername() + "'";
                    String getProfSurname= "SELECT users.Surname FROM users WHERE Username='" + professore.getUsername() + "'";
                    DB_Connection_Users db_connection_users = new DB_Connection_Users();
                    db_connection_users.connect_Users();
                    Statement statement3 = conn_Users.createStatement();
                    ResultSet rsName = statement3.executeQuery(getProfName);
                    if(rsName.next()){
                        nameProf=rsName.getString("Name");
                    }

                    Statement statement1 = conn_Users.createStatement();
                    ResultSet rsSurname = statement1.executeQuery(getProfSurname);
                    if(rsSurname.next()){
                        surnameProf =rsSurname.getString("Surname");
                    }

                    Controller c13 = new Controller();
                    c13.write(nameAula, tipoPrenota, timeInizioPrenota, timeFinePrenota, nameProf, surnameProf);
                    }
                }catch(Exception ex){
                    System.err.println(ex);
                }

                //------------------SEGRETARIA--------------------//


            } else{
                System.out.println("CISTOOOOOOOOOOOO");
                String controlQuery = "SELECT DISTINCT Nome FROM dati WHERE Nome NOT IN (SELECT Nome FROM Aule.dati " +
                        "WHERE DataPr='" + dataPrenota + "'" +
                        " AND ((Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "') " +
                        "" + "OR (Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " +
                        "OR (Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "') " +
                        "OR ((Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "') " +
                        "AND (Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "'))))";
                try {
                    DB_Connection_Aule db_connection_aule = new DB_Connection_Aule();
                    db_connection_aule.connect_Aule();
                    Statement statement = conn_Aule.createStatement();
                    ResultSet resultSet = statement.executeQuery(controlQuery);
                    if (!resultSet.wasNull()) {

                        //----------------DUPLICATE ENTRY: SI CANCELLANO LE AULE CHE DANNO FASTIDIO ALLA NUOVA
                        //----------------PRENOTAZIONE-----------------------//

                        try {
                            String deleteSecretary = "DELETE FROM Aule.dati WHERE DataPr='" + dataPrenota + "'" +
                                    " AND ((Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "') " +
                                    "OR (Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "') " +
                                    "OR (Inizio>='" + timeInizioPrenota + "' AND Fine<='" + timeFinePrenota + "') " +
                                    "OR ((Inizio<='" + timeInizioPrenota + "' AND Fine>='" + timeInizioPrenota + "')" +
                                    " AND (Fine>='" + timeFinePrenota + "' AND Inizio<='" + timeFinePrenota + "')))";

                            DB_Connection_Aule db_connection_aule1 = new DB_Connection_Aule();
                            db_connection_aule1.connect_Aule();
                            Statement statement1 = conn_Aule.createStatement();
                            statement1.executeUpdate(deleteSecretary);
                            String insertSecretary = "INSERT INTO Aule.dati (Nome, TipoPr, DataPr, Inizio, Fine, FromP) " +
                                    "VALUES " + "('" + nameAula + "','" + tipoPrenota + "','" + dataPrenota + "','"
                                    + timeInizioPrenota + "','" + timeFinePrenota + "','Secretary')";
                            DB_Connection_Aule db_connection_aule2 = new DB_Connection_Aule();
                            db_connection_aule2.connect_Aule();
                            Statement statement2 = conn_Aule.createStatement();
                            statement2.executeUpdate(insertSecretary);

                        } catch (Exception ex1) {
                            ex1.printStackTrace();
                        }
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }

