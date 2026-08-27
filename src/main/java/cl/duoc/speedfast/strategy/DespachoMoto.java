package cl.duoc.speedfast.strategy;

import cl.duoc.speedfast.model.Pedido;

public class DespachoMoto implements DespachoStrategy {

    @Override
    public void despacharPedido(Pedido pedido) {
        System.out.println("→ El pedido está siendo despachado en moto.\n");
    }
}
