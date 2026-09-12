package concurrencia;

import model.Pedido;
import model.EstadoPedido;

import java.util.Random;

/*
 * Representa a un repartidor que procesa pedidos de forma concurrente.
 * Cada repartidor funciona como una tarea independiente mediante Runnable.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private Random random = new Random();

    /*
     * Constructor del repartidor.
     */
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    /*
     * Retira pedidos desde la zona de carga compartida
     * hasta que ya no queden pedidos disponibles.
     */
    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);

            System.out.println(
                    "[Repartidor - " + nombre + "] Retirando pedido #"
                            + pedido.getIdPedido() + "...\n"
                            + "[Repartidor - " + nombre + "] Estado: "
                            + pedido.getEstado() + "\n"
                            + "[Repartidor - " + nombre + "] Entregando pedido #"
                            + pedido.getIdPedido() + "..."
            );

            try {

                int tiempoEspera = 1000 + random.nextInt(2000);

                Thread.sleep(tiempoEspera);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println(
                        "[Repartidor - " + nombre + "] Estado: "
                                + pedido.getEstado() + "\n"
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "[Repartidor - " + nombre
                                + "] Entrega interrumpida."
                );

                return;
            }
        }
    }
}