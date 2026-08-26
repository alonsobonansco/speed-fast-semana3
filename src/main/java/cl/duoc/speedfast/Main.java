package cl.duoc.speedfast;

import cl.duoc.speedfast.model.PedidoComida;
import cl.duoc.speedfast.strategy.DespachoMoto;

public class Main {
    static void main() {
        PedidoComida pedidoComida = new PedidoComida(
                "001", "calle 123", 14.0,
                new DespachoMoto(), true);
        pedidoComida.mostrarResumen();

        pedidoComida.despachar();
    }
}
