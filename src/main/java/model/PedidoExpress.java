package model;

import interfaces.Despachable;
import interfaces.Rastreable;

/*
 * Clase hija de Pedido.
 * Representa pedidos Express de SpeedFast.
 * Implementa las capacidades de despachar y rastrear pedidos.
 */
public class PedidoExpress extends Pedido implements Despachable, Rastreable {

    /*
     * Constructor de PedidoExpress.
     * Envía los datos comunes al constructor de la clase padre Pedido.
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /*
     * Calcula el tiempo estimado de entrega para un pedido Express.
     * Sobrescribe el método abstracto definido en Pedido.
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;

        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }

        return tiempo;
    }

    @Override
    public void despachar() {
        System.out.println("Pedido Express despachado.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoExpress #" + getIdPedido()
                        + " - entregado por " + getNombreRepartidor()
        );
    }

    /*
     * Asigna automáticamente un repartidor para pedidos Express.
     * Sobrescribe el comportamiento general definido en Pedido.
     */
    @Override
    public void asignarRepartidor() {
        asignarRepartidor("Sebastián Rojas");
    }
}