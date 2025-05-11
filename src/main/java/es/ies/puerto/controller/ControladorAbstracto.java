package es.ies.puerto.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorAbstracto {

    static final String PATH_DB = "src/main/resources/CazadoresM.db";

    private UsuarioServiceModel usuarioServiceModel;

    private Properties propertiesIdioma;

    private static Usuario usuarioActivo;

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

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario usuarioActivoB) {
        usuarioActivo = usuarioActivoB;
    }

    public ControladorAbstracto() {
        try {
            usuarioServiceModel = new UsuarioServiceModel(PATH_DB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setpropertiesIdioma(Properties properties) {
        propertiesIdioma = properties;
    }

    public Properties getPropertiesIdioma() {
        return propertiesIdioma;
    }

    public UsuarioServiceModel getUsuarioServiceModel() {
        return this.usuarioServiceModel;
    }

    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();
        if (nombreFichero == null || idioma == null) {
            return properties;
        }
        String path = "src/main/resources/" + nombreFichero + "-" + idioma + ".properties";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Path:" + file.getAbsolutePath());
            return properties;
        }
        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            properties.load(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

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
            Scene scene = new Scene(fxmlLoader.load(), 1050.0, 760.0);
            stage.setTitle(tituloDePagina);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void openPantalla(Button boton, String fxml, String tituloDePagina, Usuario usuario) {
        if (boton == null || fxml == null || fxml.isEmpty() || tituloDePagina == null || tituloDePagina.isEmpty()
                || usuario == null) {
            return;
        }
        try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            PerfilController perfilController = fxmlLoader.getController();
            perfilController.cargarDatosUsuario(usuario);
            stage.setTitle(tituloDePagina);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
