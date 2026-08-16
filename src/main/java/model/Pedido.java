package model;

import interfaces.Asignable;

/*
 * Clase base que representa un pedido de SpeedFast.
 * Contiene los datos comunes para todos los tipos de pedido.
 */
public class Pedido implements Asignable {

    // Atributos principales del pedido
    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    /*
     * Constructor de la clase Pedido.
     * Inicializa los datos principales del pedido.
     */
    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    // Obtiene el identificador del pedido
    public String getIdPedido() {
        return idPedido;
    }

    // Permite modificar el identificador del pedido
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    // Obtiene la dirección de entrega
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    // Permite modificar la dirección de entrega
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    // Obtiene el tipo de pedido
    public String getTipoPedido() {
        return tipoPedido;
    }

    // Permite modificar el tipo de pedido
    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    /*
     * Método general para asignar un repartidor.
     * Las clases hijas sobrescribirán este comportamiento.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor...");
    }

}