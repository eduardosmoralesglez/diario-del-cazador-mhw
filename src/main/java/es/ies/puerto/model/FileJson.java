package es.ies.puerto.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FileJson {
    String path = "src/main/resources/usuarios.json";
    File file;
    ObjectMapper objectMapper;
    List<Usuario> listUsuarios;

    public FileJson() {
        try {
            listUsuarios = new ArrayList<>();
            objectMapper = new ObjectMapper();
            file = new File(path);
            if (!file.exists() || !file.isFile()) {
                file.createNewFile();
            }
            loadAll();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Funcion para cargar el fichero en un List<Usuario>
     * @return List<Usuario>/Exception
     */
    public List<Usuario> loadAll() {
        try {
            listUsuarios = objectMapper.readValue(file, new TypeReference<List<Usuario>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUsuarios;
    }

    /**
     * Funcion para actualizar el fichero
     * @param file fichero a actualizar
     * @param lista lista de usuarios actualizada
     */
    public void updateFile(File file, List<Usuario> lista) {
        try {
            objectMapper.writeValue(file, lista);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * Funcion para aniadir un usuario al fichero
     * @param usuario
     * @return true/false
     */
    public boolean add(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        boolean aniadir  = false;
        if (!listUsuarios.contains(usuario)) {
            aniadir = listUsuarios.add(usuario);
        }
        if (aniadir) {
            updateFile(file, listUsuarios);
        }
        return aniadir;
    }

    /**
     * Funcion para eliminar un usuario del fichero
     * @param obj Usuario a eliminar
     * @return true/false
     */
    public boolean delete(Usuario obj) {
        if (obj == null) {
            return false;
        }
        boolean delete = false;
        if (listUsuarios.contains(obj)) {
            delete = listUsuarios.remove(obj);
        }
        if (delete) {
            updateFile(file, listUsuarios);
        }
        return delete;
    }

    /**
     * Funcion para leer la lista de caballero
     * @return List<Usuario>
     */
    public List<Usuario> getList() {
        return listUsuarios;
    }

    public Usuario buscarUsuario(String usuario, String password) {
        if (usuario == null || usuario.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        for (Usuario usuarioBuscado : listUsuarios) {
            if (usuarioBuscado.getUsuario().equals(usuario) || usuarioBuscado.getEmail().equals(usuario) && usuarioBuscado.getPassword().equals(password)) {
                return usuarioBuscado;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }
        for (Usuario usuarioBuscado : listUsuarios) {
            if (usuarioBuscado.getEmail().equals(email)) {
                return usuarioBuscado;
            }
        }
        return null;
    }

}
