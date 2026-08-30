package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

/*
 * Clase hija de Pedido.
 * Representa pedidos de comida de SpeedFast.
 * Implementa las capacidades de cancelar, despachar y rastrear pedidos.
 */
public class PedidoComida extends Pedido implements Cancelable, Despachable, Rastreable {

    /*
     * Constructor de PedidoComida.
     * Envía los datos comunes al constructor de la clase padre Pedido.
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Calcula el tiempo estimado de entrega para un pedido de comida.
     * Sobrescribe el método abstracto definido en Pedido.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = 15 + 2 * getDistanciaKm();
        return (int) Math.round(tiempo);
    }

    @Override
    public void despachar() {
        System.out.println("Pedido de comida despachado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido de comida cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoComida #" + getIdPedido()
                        + " - entregado por " + getNombreRepartidor()
        );
    }

    /*
     * Asigna automáticamente un repartidor para pedidos de comida.
     * Sobrescribe el comportamiento general definido en Pedido.
     */
    @Override
    public void asignarRepartidor() {
        asignarRepartidor("Luis Díaz");
    }
}