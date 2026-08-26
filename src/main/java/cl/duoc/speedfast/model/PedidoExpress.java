package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

public class PedidoExpress extends Pedido {

    private static final double LIMITE_DISTANCIA_KM = 20;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho) {
        super("PEDIDO EXPRESS", idPedido, direccionEntrega, distanciaKm, estrategiaDespacho);
    }

    @Override
    protected boolean validarPedido() {
        System.out.println("Verificando que la distancia esté dentro del límite permitido...");

        if (getDistanciaKm() > LIMITE_DISTANCIA_KM) {
            System.out.println("[ERROR] No es posible realizar un envío express por la distancia.\n");
            return false;
        }

        System.out.println("[OK] Distancia dentro del límite.\n");
        return true;
    }

    protected int calcularTiempoEntrega() {
        return (getDistanciaKm() > 5) ? 15 : 10;
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
