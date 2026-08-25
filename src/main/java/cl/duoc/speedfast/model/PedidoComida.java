package cl.duoc.speedfast.model;

public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, boolean mochilaEnBuenEstado) {
        super("PEDIDO COMIDA", idPedido, direccionEntrega, distanciaKm);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }

    protected int calcularTiempoEntrega() {
        return -1;
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
