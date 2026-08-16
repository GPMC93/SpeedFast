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
    public PedidoComida(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    /*
     * Sobrescribe el método heredado de Pedido.
     * Aplica la asignación específica para pedidos de comida.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor con mochila térmica.");
    }

    /*
     * Sobrecarga del método asignarRepartidor.
     * Recibe el nombre del repartidor asignado.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Verificando mochila térmica... OK");
        System.out.println("Pedido asignado a " + nombreRepartidor);
    }

}