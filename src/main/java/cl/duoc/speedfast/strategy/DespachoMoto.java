package cl.duoc.speedfast.strategy;

public class DespachoMoto implements DespachoStrategy {

    @Override
    public void despacharPedido() {
        System.out.println("El pedido está siendo despachado en moto.");
    }
}
