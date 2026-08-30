package model;

public abstract class Pedido {

    // Atributos comunes para todos los tipos de pedido
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    private String nombreRepartidor;

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

    public String getNombreRepartidor() {
        return nombreRepartidor;
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
     * Asignación automática de repartidor.
     * Las clases hijas pueden sobrescribir este comportamiento.
     */
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor al pedido...");
    }

    /*
     * Sobrecarga del método asignarRepartidor.
     * Permite asignar manualmente un repartidor y guardar su nombre.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }

    /*
     * Cada clase hija debe implementar su propio cálculo
     * de tiempo de entrega.
     */
    public abstract int calcularTiempoEntrega();
}