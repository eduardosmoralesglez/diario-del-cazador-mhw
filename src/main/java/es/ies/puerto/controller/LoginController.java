package es.ies.puerto.controller;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.model.FileJson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends ControladorAbstracto {

    public FileJson fichero;

    private final String pathFichero = "src/main/resources/";
    private final String ficheroStr = "idioma-";

    public LoginController() {
        fichero = new FileJson();
    }

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Text textFieldMensaje;

    @FXML
    private Button openPerfilButton;

    @FXML
    private Button openRegistrarButton;

    @FXML
    private Button openRecuperarButton;

    @FXML
    private Button buttonLista;

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

    @FXML
    protected void onLoginButtonClick() {

        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty() ||
                textFieldPassword == null || textFieldPassword.getText().isEmpty()) {
            textFieldMensaje.setText("Credenciales null o vacias");
            return;
        }

        setUsuarioActivo(getUsuarioServiceModel().obtenerUsuarioPorEmailOrUsuario(textFieldUsuario.getText()));
        if (getUsuarioActivo() == null) {
            textFieldMensaje.setText("Usuario no registrado");
            return;
        }

        boolean passwordCorrecta = getUsuarioActivo().getPassword().equals(textFieldPassword.getText());
        if (!passwordCorrecta) {
            textFieldMensaje.setText("Contraseña incorrecta");
            return;
        }
        textFieldMensaje.setText("Usuario validado correctamente");

        openPantalla(openPerfilButton, "perfil.fxml", "Pantalla del Perfil", getUsuarioActivo());
    }

    @FXML
    protected void onClickButtonLista() {
        openPantalla(buttonLista, "lista.fxml", "Pantalla de lista de Usuarios");
    }

    @FXML
    protected void openRegistrar() {
        openPantalla(openRegistrarButton, "registro.fxml", "Pantalla de Registro");
    }

    @FXML
    protected void openRecuperar() {
        openPantalla(openRecuperarButton, "recuperar.fxml", "Pantalla de Recuperación");
    }
}