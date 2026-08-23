package model;

/*
 * Clase hija de Pedido.
 * Representa pedidos de comida de SpeedFast.
 */
public class PedidoComida extends Pedido {

    /*
     * Constructor de PedidoComida.
     * Llama al constructor de la clase padre Pedido.
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Sobrescribe el método abstracto heredado de Pedido.
     * Calcula el tiempo estimado para pedidos de comida.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 15 + 2 * getDistanciaKm();
        return (int) tiempo;
    }
}