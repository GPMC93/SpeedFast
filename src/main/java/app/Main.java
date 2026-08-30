package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import interfaces.Despachable;
import interfaces.Cancelable;
import interfaces.Rastreable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /*
         * Creación de objetos.
         * Cada objeto corresponde a un tipo específico de pedido.
         */
        PedidoComida pedidoComida =
                new PedidoComida(1, "Av. Italia 456", 4);

        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda(2, "Av. Independencia 123", 6);

        PedidoExpress pedidoExpress =
                new PedidoExpress(3, "Av. Apoquindo 1500", 7);


        /*
         * Lista que almacena distintos tipos de pedidos.
         * Todos pueden guardarse aquí porque heredan de Pedido.
         */
        ArrayList<Pedido> pedidos = new ArrayList<>();

        pedidos.add(pedidoComida);
        pedidos.add(pedidoEncomienda);
        pedidos.add(pedidoExpress);


        /*
         * Se procesan los pedidos utilizando polimorfismo.
         */
        for (Pedido pedido : pedidos) {

            pedido.mostrarResumen();
            pedido.asignarRepartidor();

            System.out.println(
                    "Tiempo estimado de entrega: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );

            if (pedido instanceof Despachable) {
                ((Despachable) pedido).despachar();
            }

            System.out.println();
        }


        /*
         * Demostración de asignación manual.
         */
        System.out.println("=== Asignación manual ===");
        pedidoComida.asignarRepartidor("Carlos");
        System.out.println();


        /*
         * Demostración de cancelación.
         */
        System.out.println("=== Cancelación ===");

        if (pedidoEncomienda instanceof Cancelable) {
            ((Cancelable) pedidoEncomienda).cancelar();
        }

        System.out.println();


        /*
         * Historial de pedidos.
         */
        System.out.println("=== Historial ===");

        for (Pedido pedido : pedidos) {

            if (pedido instanceof Rastreable) {
                ((Rastreable) pedido).verHistorial();
            }
        }
    }
}