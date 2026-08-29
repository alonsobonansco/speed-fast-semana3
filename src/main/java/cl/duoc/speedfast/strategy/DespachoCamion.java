package cl.duoc.speedfast.strategy;

import cl.duoc.speedfast.model.Pedido;

/**
 * Estrategia de despacho realizada en Camión.
 */
public class DespachoCamion implements DespachoStrategy {
    @Override
    public void despacharPedido(Pedido pedido) {
        System.out.println("→ El pedido está siendo despachado en camión.\n");
    }
}
