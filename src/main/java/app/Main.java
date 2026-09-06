package app;

import concurrencia.Repartidor;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import interfaces.Despachable;
import interfaces.Cancelable;
import interfaces.Rastreable;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /*
         * Creación de pedidos.
         * Se crean seis pedidos para distribuirlos entre tres repartidores.
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
         * Lista general de pedidos.
         * Se mantiene para demostrar polimorfismo y funcionalidades previas.
         */
        ArrayList<Pedido> pedidos = new ArrayList<>();

        pedidos.add(pedidoComida1);
        pedidos.add(pedidoEncomienda1);
        pedidos.add(pedidoExpress1);
        pedidos.add(pedidoComida2);
        pedidos.add(pedidoEncomienda2);
        pedidos.add(pedidoExpress2);


        /*
         * Procesamiento general de los pedidos.
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
        pedidoComida1.asignarRepartidor("Carlos");
        System.out.println();


        /*
         * Demostración de cancelación.
         */
        System.out.println("=== Cancelación ===");

        if (pedidoEncomienda1 instanceof Cancelable) {
            ((Cancelable) pedidoEncomienda1).cancelar();
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

        System.out.println();


        /*
         * Listas de pedidos asignadas a cada repartidor
         */
        ArrayList<Pedido> pedidosCamila = new ArrayList<>();
        pedidosCamila.add(pedidoComida1);
        pedidosCamila.add(pedidoExpress1);

        ArrayList<Pedido> pedidosLuis = new ArrayList<>();
        pedidosLuis.add(pedidoEncomienda1);
        pedidosLuis.add(pedidoComida2);

        ArrayList<Pedido> pedidosDaniel = new ArrayList<>();
        pedidosDaniel.add(pedidoEncomienda2);
        pedidosDaniel.add(pedidoExpress2);


        /*
         * Creación de repartidores
         * Cada repartidor implementa Runnable
         */
        Repartidor camila = new Repartidor("Camila", pedidosCamila);
        Repartidor luis = new Repartidor("Luis", pedidosLuis);
        Repartidor daniel = new Repartidor("Daniel", pedidosDaniel);


        /*
         * Ejecución concurrente de los repartidors
         */
        System.out.println("=== Entregas concurrentes ===");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(camila);
        executor.execute(luis);
        executor.execute(daniel);

        executor.shutdown();

        try {

            /*
             * Espera hasta que todos los repartidores terminen
             */
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("=== Todas las entregas finalizaron ===");
    }
}