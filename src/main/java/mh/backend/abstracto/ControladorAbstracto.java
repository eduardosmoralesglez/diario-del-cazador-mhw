package mh.backend.abstracto;

import mh.config.ConfigManager;
import mh.frontend.view.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorAbstracto {
    
    @FXML
    public Text textUsuario;

    @FXML
    public Text textContrasenia;

    @FXML
    public Text textContraseniaRepetir;

    @FXML
    public Text textName;

    @FXML
    public Text textEmail;

    @FXML
    public Text textEmailRepetir;

    public void cambiarIdioma() {
        if (textUsuario != null) {
            textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        }
        if (textContrasenia != null) {
            textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
        }
        if (textContraseniaRepetir != null) {
            textContraseniaRepetir.setText(ConfigManager.ConfigProperties.getProperty("textContraseniaRepetir"));
        }
        if (textName != null) {
            textName.setText(ConfigManager.ConfigProperties.getProperty("textName"));
        }
        if (textEmail != null) {
            textEmail.setText(ConfigManager.ConfigProperties.getProperty("textEmail"));
        }
        if (textEmailRepetir != null) {
            textEmailRepetir.setText(ConfigManager.ConfigProperties.getProperty("textEmailRepetir"));
        }
    }

    @FXML
    protected void openPantalla(Button boton, String fxml, String tituloDePagina) {
        if (boton == null || fxml == null || fxml.isEmpty() || tituloDePagina == null || tituloDePagina.isEmpty()) {
            return;
        }
        try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle(tituloDePagina);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
