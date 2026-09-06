package concurrencia;

import model.Pedido;

import java.util.ArrayList;
import java.util.Random;


/*
 * Representa a un repartidor que procesa pedidos de forma concurrente.
 * Cada repartidor funciona como una tarea independiente mediante Runnable.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private ArrayList<Pedido> pedidos;
    private Random random = new Random();

    /*
     * Constructor del repartidor.
     */
    public Repartidor(String nombre, ArrayList<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    /*
     * Ejecuta secuencialmente los pedidos asignados al repartidor.
     * Cada repartidor puede ejecutarse en paralelo con otros repartidores.
     */
    @Override
    public void run() {

        for (Pedido pedido : pedidos) {

            System.out.println(
                    "[Repartidor: " + nombre + "] Entregando "
                            + pedido.getClass().getSimpleName()
                            + " #" + pedido.getIdPedido() + "..."
            );

            try {
                int tiempoEspera = 1000 + random.nextInt(2000);
                Thread.sleep(tiempoEspera);

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido()
                                + " entregado."
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                        "[Repartidor: " + nombre
                                + "] Entrega interrumpida."
                );

                return;
            }
        }
    }
}