package es.ies.puerto.model;

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
            String sql = "SELECT * FROM cazador WHERE email='"+imput+"' OR usuario='"+imput+"'";
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
            String sql = "SELECT * FROM cazador";
            return obtenerUsuario(sql);
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
                String usuarioStr = resultado.getString("usuario");
                String nombreStr = resultado.getString("nombre");
                String contraseniaStr = resultado.getString("contrasenia");
                String emailStr = resultado.getString("email");
                Usuario usuarioModel = new Usuario(usuarioStr,contraseniaStr,nombreStr,emailStr);
                usuarios.add(usuarioModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }

    public boolean InsertarUsuario(Usuario usuario) throws SQLException {
        if (usuario == null) {
            return false;
        }
        String sql = "INSERT INTO cazador VALUES ('"+usuario.getUsuario()+"','"+usuario.getNombre()+"','"+usuario.getPassword()+"','"+usuario.getEmail()+"')";
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            sentencia.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            cerrar();
        }
    }

    public boolean InsertarMonstruo(Monstruo monstruo) throws SQLException {
        if (monstruo == null) {
            return false;
        }
        String sql = "INSERT INTO monstruo VALUES ('"+monstruo.getNombre()+"','"+monstruo.getTipo()+"','"+monstruo.getClase()+"','"+monstruo.getDescripcion()+"', '"+monstruo.getPathImagen()+"')";
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            sentencia.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            cerrar();
        }
    }
}
