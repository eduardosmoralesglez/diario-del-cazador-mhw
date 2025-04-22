package es.ies.puerto.controller;

import es.ies.puerto.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InicioController extends ControladorAbstracto {

    private final String pathFichero = "src/main/resources/";
    private final String ficheroStr = "idioma-";
    
    @FXML
    private Button buttonInicioIngresar;

    @FXML
    private ComboBox comboIdioma;

    @FXML
    protected void onClickInicioIngresar() {
        openPantalla(buttonInicioIngresar, "login.fxml", "Pantalla de Login");
    }

        @FXML
    public void initialize() {
        comboIdioma.getItems().add("es");
        comboIdioma.getItems().add("en");
        comboIdioma.getItems().add("fr");
        cambiarIdioma();
        cargarIdioma("es");
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
