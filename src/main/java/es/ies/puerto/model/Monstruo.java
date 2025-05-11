package es.ies.puerto.model;

public class Monstruo {
    private String nombre;
    private String tipo;
    private String clase;
    private String descripcion;
    private String pathImagen;

    public Monstruo() {
    }

    public Monstruo(String nombre) {
        this.nombre = nombre;
    }

    public Monstruo(String nombre, String tipo, String clase, String descripcion, String pathImagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.clase = clase;
        this.descripcion = descripcion;
        this.pathImagen = pathImagen;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPathImagen() {
        return this.pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", clase='" + getClase() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }

}
