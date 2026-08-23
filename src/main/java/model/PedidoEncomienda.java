package model;

/*
 * Clase hija de Pedido.
 * Representa pedidos de encomienda de SpeedFast.
 */
public class PedidoEncomienda extends Pedido {

    /*
     * Constructor de PedidoEncomienda.
     * Llama al constructor de la clase padre Pedido.
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Sobrescribe el método abstracto heredado de Pedido.
     * Calcula el tiempo estimado para pedidos de encomienda.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 20 + 1.5 * getDistanciaKm();
        return (int) tiempo;
    }
}