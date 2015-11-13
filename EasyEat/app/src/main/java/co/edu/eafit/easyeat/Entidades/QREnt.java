package co.edu.eafit.easyeat.Entidades;

/**
 * Created by Julian on 12/11/2015.
 */

public class QREnt {
    private RestauranteEnt restaurante;
    private int mesa;

    public QREnt(RestauranteEnt restaurante, int mesa) {
        this.restaurante = restaurante;
        this.mesa = mesa;
    }

    public RestauranteEnt getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEnt restaurante) {
        this.restaurante = restaurante;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}