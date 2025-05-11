package es.ies.puerto.controller;

import java.sql.SQLException;

import es.ies.puerto.model.Monstruo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateMController extends ControladorAbstracto{

    @FXML
    private Text textCreateMText;
    
    @FXML
    private TextField textFieldCreateNombre;

    @FXML
    private TextArea textAreaCreateDescripcion;

    @FXML
    private Button buttonCreateM;

    @FXML
    private Button buttonCreateVolver;

    @FXML
    private ChoiceBox choiceBoxCreateTipo;

    @FXML
    private ChoiceBox choiceBoxCreateClase;

    @FXML
    public void initialize() {
        choiceBoxCreateTipo.getItems().add("Volador");
        choiceBoxCreateTipo.getItems().add("Nadador");
        choiceBoxCreateTipo.getItems().add("Colmillos");
        choiceBoxCreateTipo.getItems().add("Pajaro");
        choiceBoxCreateTipo.getItems().add("Brutal");

        choiceBoxCreateClase.getItems().add("Pequeño");
        choiceBoxCreateClase.getItems().add("Grande");
        choiceBoxCreateClase.getItems().add("Anciano");
    }

    @FXML
    protected void onClickCreateM() throws SQLException{
        
        if (textFieldCreateNombre == null || textFieldCreateNombre.getText().isEmpty()) {
            textCreateMText.setText("Nombre no puede ser vacio o nulo");
            return;
        }
        if (choiceBoxCreateTipo.getValue() == null) {
            textCreateMText.setText("El Tipo no puede ser nulo");
            return;
        }
        if (choiceBoxCreateClase.getValue() == null) {
            textCreateMText.setText("La Clase no puede ser nula");
            return;
        }
        if (textAreaCreateDescripcion == null || textAreaCreateDescripcion.getText().isEmpty()) {
            textCreateMText.setText("La Descripción no puede ser nula");
            return;
        }
        textCreateMText.setText("Monstruo creado correctamente");
        String path = "src/main/resources/"+textFieldCreateNombre+".png";
        Monstruo monstruo = new Monstruo(textFieldCreateNombre.getText(), choiceBoxCreateTipo.getValue().toString(), choiceBoxCreateClase.getValue().toString(), textAreaCreateDescripcion.getText(), path);
        getUsuarioServiceModel().InsertarMonstruo(monstruo);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        openPantalla(buttonCreateM, "creacionM.fxml", "Creación");
    }

    @FXML
    protected void onClickCreateVolver() {
        openPantalla(buttonCreateVolver, "bestiario.fxml", "Bestiario");
    }








}
