package Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class Classroom_Professore {

    @FXML
    private javafx.scene.control.TableView<Classroom_Segretaria> tableProf;
    @FXML
    private TableColumn<Classroom_Professore, String> columnNameProf;
    @FXML
    private TableColumn<Classroom_Professore, String> columnDataProf;
    @FXML
    private TableColumn<Classroom_Professore, String> columnOraProf;
    @FXML
    private TableColumn<Classroom_Professore, String> columnTipoProf;

    private StringProperty name;

    public Classroom_Professore(String name) {
        this.name = new SimpleStringProperty(name);
    }
    public String getName(){return name.get();}
    public void setName(String value){
        name.set(value);
    }
    public StringProperty nameProperty(){
        return name;
    }

}
