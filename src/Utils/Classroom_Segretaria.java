package Utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class Classroom_Segretaria {

    @FXML
    private javafx.scene.control.TableView<Classroom_Segretaria> table;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnAulaSecretary;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnTipoSecretary;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnDataSecretary;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnInizioSecretary;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnFineSecretary;
    @FXML
    private TableColumn<Classroom_Segretaria, String> columnFromSecretary;
    @FXML

    private StringProperty name;
    private StringProperty tipo;
    private StringProperty data;
    private StringProperty ora;
    private StringProperty ora1;
    private StringProperty from;

    public Classroom_Segretaria(String name, String tipo, String data, String ora, String ora1, String from) {
        this.name = new SimpleStringProperty(name);
        this.tipo = new SimpleStringProperty(tipo);
        this.data = new SimpleStringProperty(data);
        this.ora = new SimpleStringProperty(ora);
        this.ora1 = new SimpleStringProperty(ora1);
        this.from = new SimpleStringProperty(from);
    }
    public String getName(){return name.get();}
    public String getTipo(){return tipo.get();}
    public String getData(){return data.get();}
    public String getOra(){return ora.get();}
    public String getOra1(){return ora1.get();}
    public String getFrom(){return from.get();}

    public void setName(String value){
        name.set(value);
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
    public void setFrom(String value) {
        from.set(value);
    }

    public StringProperty tipoProperty() {
        return tipo;
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
    public StringProperty fromProperty() {
        return from;
    }
}
