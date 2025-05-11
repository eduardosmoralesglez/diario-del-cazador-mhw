package es.ies.puerto.controller;

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
    private TextField textFieldCreateId;

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
        choiceBoxCreateTipo.getItems().add("es");
        choiceBoxCreateTipo.getItems().add("f");

        choiceBoxCreateClase.getItems().add("asd");
        choiceBoxCreateClase.getItems().add("qwerty");
    }

    @FXML
    protected void onClickCreateM() {
        
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
        try {
            wait(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        openPantalla(buttonCreateM, "creacionM.fxml", "Creación");
    }

    @FXML
    protected void onClickCreateVolver() {

    }








}
