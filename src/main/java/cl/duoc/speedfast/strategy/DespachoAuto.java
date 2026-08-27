package cl.duoc.speedfast.strategy;

import cl.duoc.speedfast.model.Pedido;

public class DespachoAuto implements DespachoStrategy {

    @Override
    public void despacharPedido(Pedido pedido) {
        System.out.println("→ El pedido está siendo despachado en auto.\n");
    }
}
