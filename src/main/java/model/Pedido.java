package model;

public abstract class Pedido {

    // Atributos comunes para todos los tipos de pedido
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    /*
     * Constructor de la clase Pedido.
     * Inicializa los datos principales del pedido.
     */
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    /*
     * Muestra los datos generales del pedido.
     */
    public void mostrarResumen() {
        System.out.println(getClass().getSimpleName() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }
    /*
     * Cada clase hija debe implementar su propio cálculo.
     */
    public abstract int calcularTiempoEntrega();
}