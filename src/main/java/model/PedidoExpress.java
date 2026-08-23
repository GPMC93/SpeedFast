package model;

/*
 * Clase hija de Pedido.
 * Representa pedidos Express de SpeedFast.
 */
public class PedidoExpress extends Pedido {

    /*
     * Constructor de PedidoExpress.
     * Llama al constructor de la clase padre Pedido.
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Sobrescribe el método abstracto heredado de Pedido.
     * Calcula el tiempo estimado para pedidos Express.
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;

        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }

        return tiempo;
    }
}