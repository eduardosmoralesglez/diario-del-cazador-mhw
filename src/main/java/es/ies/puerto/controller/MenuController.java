package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController extends ControladorAbstracto {
    
    @FXML
    private Button investigacionMenu;

    @FXML
    private Button crearMenu;

    @FXML
    private Button bestiarioMenu;

    @FXML
    private Button volverMenu;

    @FXML
    private Button perfilMenu;

    @FXML
    protected void onClickInvestigacionMenu() {
        openPantalla(investigacionMenu, "investigacion.fxml", "Investigaciones");
    }

    @FXML
    protected void onClickCrearMenu() {
        openPantalla(crearMenu, "crearI.fxml", "Crear Investigaciones");
    }

    @FXML
    protected void onClickBestiarioMenu() {
        openPantalla(bestiarioMenu, "bestiario.fxml", "Bestiario");
    }

    @FXML
    protected void onClickVolverMenu() {
        openPantalla(volverMenu, "login.fxml", "Login");
    }

    @FXML
    protected void onClickPerfilMenu() {
        openPantalla(perfilMenu, "perfil.fxml", "Perfil", getUsuarioActivo());
    }
    
}
