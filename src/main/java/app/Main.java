package app;

import concurrencia.Repartidor;
import concurrencia.ZonaDeCarga;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /*
         * Creación de pedidos.
         * Todos parten automáticamente con estado PENDIENTE.
         */
        PedidoComida pedidoComida1 =
                new PedidoComida(1, "Av. Italia 456", 4);

        PedidoEncomienda pedidoEncomienda1 =
                new PedidoEncomienda(2, "Av. Independencia 123", 6);

        PedidoExpress pedidoExpress1 =
                new PedidoExpress(3, "Av. Apoquindo 1500", 7);

        PedidoComida pedidoComida2 =
                new PedidoComida(4, "Av. Grecia 850", 3);

        PedidoEncomienda pedidoEncomienda2 =
                new PedidoEncomienda(5, "Av. Matta 420", 8);

        PedidoExpress pedidoExpress2 =
                new PedidoExpress(6, "Av. Irarrázaval 900", 5);


        /*
         * Recurso compartido por todos los repartidores.
         */
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        System.out.println("=== Zona de carga inicializada ===");

        zonaDeCarga.agregarPedido(pedidoComida1);
        zonaDeCarga.agregarPedido(pedidoEncomienda1);
        zonaDeCarga.agregarPedido(pedidoExpress1);
        zonaDeCarga.agregarPedido(pedidoComida2);
        zonaDeCarga.agregarPedido(pedidoEncomienda2);
        zonaDeCarga.agregarPedido(pedidoExpress2);

        System.out.println();


        /*
         * Los tres repartidores comparten la misma zona de carga.
         */
        Repartidor camila =
                new Repartidor("Camila", zonaDeCarga);

        Repartidor luis =
                new Repartidor("Luis", zonaDeCarga);

        Repartidor daniel =
                new Repartidor("Daniel", zonaDeCarga);


        /*
         * Ejecución concurrente de los tres repartidores.
         */
        System.out.println("=== Inicio de entregas ===");

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        executor.execute(camila);
        executor.execute(luis);
        executor.execute(daniel);

        executor.shutdown();

        try {

            /*
             * Main espera hasta que todos los repartidores terminen.
             */
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Todos los pedidos han sido entregados correctamente"
        );
    }
}