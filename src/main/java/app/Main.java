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
                new PedidoComida("P001", "Av. Providencia 123");

        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda("P002", "Irarrazaval 200");

        PedidoExpress pedidoExpress =
                new PedidoExpress("P003", "Av. Apoquindo 1500");


        /*
         * Lista que almacena distintos tipos de pedidos.
         * Todos pueden guardarse aquí porque heredan de Pedido.
         */
        ArrayList<Pedido> pedidos = new ArrayList<>();

        pedidos.add(pedidoComida);
        pedidos.add(pedidoEncomienda);
        pedidos.add(pedidoExpress);

        System.out.println("=== POLIMORFISMO ===");

        /*
         * Polimorfismo.
         * Se recorren todos los pedidos usando una referencia de tipo Pedido.
         * Cada objeto ejecuta su propia versión sobrescrita de asignarRepartidor().
         */
        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor();
        }

        System.out.println("\n=== SOBRECARGA ===");

        /*
         * Sobrecarga.
         * Se utiliza la versión de asignarRepartidor()
         * que recibe el nombre del repartidor como parámetro.
         */
        pedidoComida.asignarRepartidor("Carlos");
        System.out.println();
        pedidoEncomienda.asignarRepartidor("Paolo");
        System.out.println();
        pedidoExpress.asignarRepartidor("Pablo");
    }
}