package cl.duoc.speedfast;

import cl.duoc.speedfast.model.PedidoComida;

public class Main {
    static void main() {
        PedidoComida pedidoComida = new PedidoComida("001", "calle 123", 14.0, true);
        pedidoComida.mostrarResumen();
        System.out.println("Hola");
    }
}
