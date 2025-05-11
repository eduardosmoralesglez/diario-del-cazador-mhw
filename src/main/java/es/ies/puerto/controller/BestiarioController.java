package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BestiarioController extends ControladorAbstracto {
    
    @FXML
    private Button monstruosPequenios;

    @FXML
    private Button monstruosGrandes;

    @FXML
    private Button volverBestiario;

    @FXML
    private Button buttonBestiarioCreate;

    @FXML
    protected void onClickMonstruosPequenios() {
        openPantalla(monstruosPequenios, "monstruosPequenios.fxml", "Monstruos Pequeños");
    }

    @FXML
    protected void onClickMonstruosGrandes() {
        openPantalla(monstruosGrandes, "monstruosGrandes.fxml", "Monstruos Grandes");
    }

    @FXML
    protected void onClickVolverBestiario() {
        openPantalla(volverBestiario, "menu.fxml", "Menu");
    }

    @FXML
    protected void onClickbestiarioCreate() {
        openPantalla(buttonBestiarioCreate, "creacionM.fxml", "Creación");
    }

}
