package cl.duoc.speedfast.model;

public class PedidoExpress extends Pedido {

    private static final double LIMITE_DISTANCIA_KM = 20;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super("PEDIDO EXPRESS", idPedido, direccionEntrega, distanciaKm);
    }

    protected int calcularTiempoEntrega() {
        return -1;
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
