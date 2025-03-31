package mh.backend.controller;

import mh.backend.abstracto.ControladorAbstracto;
import mh.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class InicioController extends ControladorAbstracto{

    private final String pathFichero = "src/main/resources/properties/";
    private final String ficheroStr = "idioma-";

    @FXML
    private Text textInicio;

    @FXML
    private ComboBox comboIdioma;

    @FXML
    public void initialize() {
        comboIdioma.getItems().add("es");
        comboIdioma.getItems().add("en");
        comboIdioma.getItems().add("fr");
        cambiarIdioma();
    }

    @FXML
    protected void seleccionarIdiomaClick() {
        String idioma = comboIdioma.getValue().toString();
        cargarIdioma(idioma);
        cambiarIdioma();
    }

    private void cargarIdioma(String idioma) {
        String path = pathFichero + ficheroStr + idioma + ".properties";
        ConfigManager.ConfigProperties.setPath(path);
    }
}
