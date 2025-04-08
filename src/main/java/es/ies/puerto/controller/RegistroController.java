package es.ies.puerto.controller;

import es.ies.puerto.model.FileJson;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController extends ControladorAbstracto{

    FileJson fileJson;

    public RegistroController() {
        fileJson = new FileJson();
    }

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private PasswordField textFieldPasswordRepetir;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldEmailRepetir;

    @FXML
    private Text textMensaje;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private Button onRegistroBackToLoginButton;

    @FXML
    protected void onClickRegistrar() {
        
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El usuario no puede ser nulo o vacio!");
            return;
        }

        if (textFieldPassword == null || textFieldPassword.getText().isEmpty() || 
        textFieldPasswordRepetir == null || textFieldPasswordRepetir.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (!textFieldPassword.getText().equals(textFieldPasswordRepetir.getText())) {
            textMensaje.setText("¡El password no es correcto!");
            return;
        }

        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("¡El nombre no puede ser nulo o vacio!");
            return;
        }

        if (textFieldEmail == null || textFieldEmail.getText().isEmpty() ||
        textFieldEmailRepetir == null || textFieldEmailRepetir.getText().isEmpty()) {
            textMensaje.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }

        if (!textFieldEmail.getText().equals(textFieldEmailRepetir.getText())) {
            textMensaje.setText("¡El Email no es correcto!");
            return;
        }

        Usuario usuario = new Usuario(textFieldUsuario.getText(), textFieldPassword.getText(), textFieldNombre.getText(), textFieldEmail.getText());
        fileJson.add(usuario);
        textMensaje.setText("¡Valores validos!");
    }

    @FXML
    protected void onClickBackToLogin() {
        openPantalla(onRegistroBackToLoginButton, "login.fxml", "Pantalla de Login");
    }
}