package Utils;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Classroom_Professore{

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public Classroom_Professore(String nome) {
        this.nome = new SimpleStringProperty(nome);
    }

    private StringProperty nome;



}
