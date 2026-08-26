package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho, boolean mochilaEnBuenEstado) {
        super("PEDIDO COMIDA", idPedido, direccionEntrega, distanciaKm, estrategiaDespacho);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }

    @Override
    protected boolean validarPedido() {
        System.out.println("Verificando que la mochila térmica esté en buen estado...");

        if (!mochilaEnBuenEstado) {
            System.out.println("[ERROR] Mochila térmica en mal estado.\n");
            return false;
        }

        System.out.println("[OK] Mochila térmica en buen estado.\n");
        return true;
    }

    protected int calcularTiempoEntrega() {
        return (int) (15 + 2 * getDistanciaKm());
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
