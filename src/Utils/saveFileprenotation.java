package Utils;

import java.io.PrintWriter;
import java.time.LocalTime;

public class saveFileprenotation {

    public void write(String nameAula, String tipoPrenota, LocalTime timeInizioPrenota, LocalTime timeFinePrenota,
                      String nameProf, String surnameProf) throws Exception{

        PrintWriter writer = new PrintWriter("/home/mattia/Scrivania/Prenotazione.txt", "UTF-8");
        writer.println("Prenotazione Effettuata:");
        writer.println("Nome:\t\t" + nameAula);
        writer.println("Per:\t\t" + tipoPrenota);
        writer.println("Inizio:\t\t" + timeInizioPrenota);
        writer.println("Fine:\t\t" + timeFinePrenota);
        writer.println("A nome di :\t" + nameProf + " " + surnameProf);
        writer.close();

    }
}
