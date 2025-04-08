package es.ies.puerto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.model.abtrastas.Conexion;

public class UsuarioServiceModel extends Conexion {

    public UsuarioServiceModel() {
    }

    public UsuarioServiceModel(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public Usuario obtenerUsuarioPorEmailOrUsuario(String imput) {
        try {
            String sql = "SELECT * FROM usuarios INNER JOIN niveles ON usuarios.id_nivel = niveles.id WHERE email='"+imput+"' OR username='"+imput+"'";
            ArrayList<Usuario> usuarios = obtenerUsuario(sql);
            if (usuarios.isEmpty()) {
                return null;
            }
            return usuarios.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public ArrayList<Usuario> obtenerUsaarios() {
        try {
            String sql = "SELECT * FROM usuarios";
            return obtenerUsuario(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public ArrayList<String> obtenerPalabrasAleatoria(String nivel) {
        try {
            String sql = "SELECT * FROM palabras INNER JOIN niveles ON palabras.id_nivel = niveles.id ORDER BY RAND() LIMIT 1";
            return obtenerPalabras(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public ArrayList<Usuario> obtenerUsuario(String sql) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String usuarioStr = resultado.getString("user");
                String nombreStr = resultado.getString("username");
                String contraseniaStr = resultado.getString("password");
                String emailStr = resultado.getString("email");
                Integer puntosInt = resultado.getInt("puntos");
                String nivelStr = resultado.getString("nivel");
                Usuario usuarioModel = new Usuario(usuarioStr,contraseniaStr,nombreStr,emailStr, puntosInt, nivelStr);
                usuarios.add(usuarioModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }

    public ArrayList<String> obtenerPalabras(String sql) throws SQLException {
        ArrayList<String> palabras = new ArrayList<String>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String palabraStr = resultado.getString("palabra");
                palabras.add(palabraStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return palabras;
    }

}
