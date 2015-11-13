package co.edu.eafit.easyeat.Entidades;

/**
 * Created by Julian on 09/11/2015.
 */

public class RestauranteEnt {
    private int id_Restaurante;
    private String Descripcion;
    private int imagen;

    public RestauranteEnt(String descripcion, int imagen) {
        Descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagen(){ return imagen; }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}