package Entity;

import javafx.beans.property.StringProperty;

public class Disponible_Room {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disponible_Room(String nome) {
        this.nome = nome;
    }

    private String nome;
}
