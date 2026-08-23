package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

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
         * Polimorfismo.
         * Se recorren todos los pedidos utilizando
         * una referencia general de tipo Pedido.
         */
        for (Pedido pedido : pedidos) {

            pedido.mostrarResumen();

            System.out.println(
                    "Tiempo estimado de entrega: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );

            System.out.println();
        }
    }
}