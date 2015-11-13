package co.edu.eafit.easyeat.Entidades;

/**
 * Created by Julian on 12/11/2015.
 */

public class PedidoEnt {
    private int id_Pedido;
    private double tiempoEspera;
    private int totalPagar;
    private int cantidad;
    private ProductoEnt producto;

    public PedidoEnt(int id_Pedido, double tiempoEspera, int totalPagar, int cantidad) {
        this.id_Pedido = id_Pedido;
        this.tiempoEspera = tiempoEspera;
        this.totalPagar = totalPagar;
        this.cantidad = cantidad;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public double getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}