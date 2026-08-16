package model;

public class PedidoExpress extends Pedido{

    /*
     * Constructor de PedidoExpress.
     * Llama al constructor de la clase padre Pedido.
     */
    public PedidoExpress(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Express");
    }

    /*
     * Sobrescribe el método heredado de Pedido.
     * Aplica la asignación específica para pedidos Express.
     */

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para pedido express.");
    }

    /*
     * Sobrecarga del método asignarRepartidor.
     * Recibe el nombre del repartidor asignado.

     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Buscando repartidor más cercano con disponibilidad inmediata... OK");
        System.out.println("Pedido asignado a " + nombreRepartidor);
    }
}
