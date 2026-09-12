package concurrencia;

import model.Pedido;

import java.util.ArrayList;

public class ZonaDeCarga {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);

        System.out.println(
                "Pedido #" + pedido.getIdPedido()
                        + " agregado. Destino: "
                        + pedido.getDireccionEntrega()
        );
    }
    public synchronized Pedido retirarPedido() {

        if (pedidos.isEmpty()) {
            return null;
        }

        return pedidos.remove(0);
    }
}