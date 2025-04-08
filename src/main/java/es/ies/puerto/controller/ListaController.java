package es.ies.puerto.controller;

import java.util.List;

import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ListaController extends ControladorAbstracto{

    private List<Usuario> listaUsuarios = getUsuarioServiceModel().obtenerUsaarios();

    @FXML
    private Text textListaTitulo;

    @FXML
    private Text textLista;

    private String listaUsuarios(List<Usuario> lista){
        String mensaje = "Mensaje";
        for (int i = 0; i < lista.size(); i++) {
            mensaje = lista.get(i).toString();
        }
        return mensaje;
    }
}
