package es.ies.puerto.controller;

import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PerfilController extends ControladorAbstracto{

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField passwordFieldPassword;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button onPerfilButton;

    @FXML
    private Button onPerfilButtonJugar;

    @FXML
    private void onClickBackToLogin() {
        openPantalla(onPerfilButton, "login.fxml", "Pagina de Login");
    }

    @FXML
    private void onClickPerfilJugar() {
        openPantalla(onPerfilButtonJugar, "juego.fxml", "Pantalla de Juego");
    }

    /**
     * Carga los datos del usuario en los campos de la interfaz grafica
     * @param usuario El objeto Usuario con los datos que se mostraran en pantalla
     */
    public void cargarDatosUsuario(Usuario usuario) {
        if (usuario != null) {
            textFieldUsuario.setText(usuario.getUsuario());
            passwordFieldPassword.setText(usuario.getPassword());
            textFieldNombre.setText(usuario.getNombre());
            textFieldEmail.setText(usuario.getEmail());
        }
    }

}
