package model;

public class PedidoEncomienda extends Pedido {

    /*
     * Constructor de PedidoEncomienda.
     * Llama al constructor de la clase padre Pedido.
     */
    public PedidoEncomienda(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Encomienda");
    }

    /*
     * Sobrescribe el método heredado de Pedido.
     * Aplica la asignación específica para pedidos de encomienda.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor para encomienda.");
    }

    /*
     * Sobrecarga del método asignarRepartidor.
     * Recibe el nombre del repartidor y realiza
     * las validaciones propias de una encomienda.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Validando peso y embalaje... OK");
        System.out.println("Pedido asignado a " + nombreRepartidor);
    }

}