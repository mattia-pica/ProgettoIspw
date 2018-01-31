package Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class Classroom {

    @FXML
    private javafx.scene.control.TableView<Classroom> table;
    @FXML
    private TableColumn<Classroom, String> columnName;
    @FXML
    private TableColumn<Classroom, String> columnData;
    @FXML
    private TableColumn<Classroom, String> columnHour;
    @FXML
    private TableColumn<Classroom, String> columnType;

    private StringProperty name;
    private StringProperty stato;
    private StringProperty tipo;
    private StringProperty data;
    private StringProperty ora;
    private StringProperty ora1;

    public Classroom(String name, String stato, String tipo, String data, String ora, String ora1) {
        this.name = new SimpleStringProperty(name);
        this.stato =new SimpleStringProperty(stato);
        this.tipo = new SimpleStringProperty(tipo);
        this.data = new SimpleStringProperty(data);
        this.ora = new SimpleStringProperty(ora);
        this.ora1 = new SimpleStringProperty(ora1);

    }

    public String getName(){return name.get();}
    public String getStato(){return stato.get();}
    public String getTipo(){return tipo.get();}
    public String getData(){return data.get();}
    public String getOra(){return ora.get();}
    public String getOra1(){return ora1.get();}


    public void setName(String value){
        name.set(value);
    }

    public void setStato(String value){
        stato.set(value);
    }

    public void setTipo(String value){
        tipo.set(value);
    }

    public void setData(String value) {
        data.set(value);
    }

    public void setOra(String value) {
        ora.set(value);
    }

    public void setOra1(String value) {
        ora1.set(value);
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public StringProperty statoProperty() {
        return stato;
    }

    public StringProperty nameProperty(){
        return name;
    }

    public StringProperty oraProperty() {
        return ora;
    }
    public StringProperty ora1Property() {
        return ora1;
    }

    public StringProperty dataProperty() {
        return data;
    }

}
