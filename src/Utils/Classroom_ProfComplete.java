package Utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Classroom_ProfComplete {

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getTipopr() {
        return tipopr.get();
    }

    public StringProperty tipoprProperty() {
        return tipopr;
    }

    public void setTipopr(String tipopr) {
        this.tipopr.set(tipopr);
    }

    public String getDatapr() {
        return datapr.get();
    }

    public StringProperty dataprProperty() {
        return datapr;
    }

    public void setDatapr(String datapr) {
        this.datapr.set(datapr);
    }

    public String getInizio() {
        return inizio.get();
    }

    public StringProperty inizioProperty() {
        return inizio;
    }

    public void setInizio(String inizio) {
        this.inizio.set(inizio);
    }

    public String getFine() {
        return fine.get();
    }

    public StringProperty fineProperty() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine.set(fine);
    }

    public String getFromp() {
        return fromp.get();
    }

    public StringProperty frompProperty() {
        return fromp;
    }

    public void setFromp(String fromp) {
        this.fromp.set(fromp);
    }

    public Classroom_ProfComplete(String nome, String tipopr, String datapr, String inizio, String fine, String fromp) {
        this.nome = new SimpleStringProperty(nome);
        this.tipopr = new SimpleStringProperty(tipopr);
        this.datapr = new SimpleStringProperty(datapr);
        this.inizio = new SimpleStringProperty(inizio);
        this.fine = new SimpleStringProperty(fine);
        this.fromp = new SimpleStringProperty(fromp);
    }

    private StringProperty nome;
    private StringProperty tipopr;
    private StringProperty datapr;
    private StringProperty inizio;
    private StringProperty fine;
    private StringProperty fromp;


}
