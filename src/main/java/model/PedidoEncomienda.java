package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

/*
 * Clase hija de Pedido.
 * Representa pedidos de encomienda de SpeedFast.
 * Implementa las capacidades de cancelar, despachar y rastrear pedidos.
 */
public class PedidoEncomienda extends Pedido implements Cancelable, Despachable, Rastreable {

    /*
     * Constructor de PedidoEncomienda.
     * Envía los datos comunes al constructor de la clase padre Pedido.
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Calcula el tiempo estimado de entrega para un pedido de encomienda.
     * Sobrescribe el método abstracto definido en Pedido.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 20 + 1.5 * getDistanciaKm();
        return (int) Math.round(tiempo);
    }

    @Override
    public void despachar() {
        System.out.println("Pedido de encomienda despachado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido de encomienda cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoEncomienda #" + getIdPedido()
                        + " - entregado por " + getNombreRepartidor()
        );
    }

    /*
     * Asigna automáticamente un repartidor para pedidos de encomienda.
     * Sobrescribe el comportamiento general definido en Pedido.
     */
    @Override
    public void asignarRepartidor() {
        asignarRepartidor("Daniela Tapia");
    }
}