package cl.duoc.speedfast.strategy;

import cl.duoc.speedfast.model.Pedido;

public interface DespachoStrategy {
    void despacharPedido(Pedido pedido);
}
