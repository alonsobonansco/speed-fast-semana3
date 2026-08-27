package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho, boolean mochilaEnBuenEstado) {
        super("PEDIDO COMIDA", idPedido, direccionEntrega, distanciaKm, estrategiaDespacho);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }

    @Override
    public boolean validarPedido() {
        System.out.println("Verificando que la mochila térmica esté en buen estado...");

        if (!mochilaEnBuenEstado) {
            System.out.println("[ERROR] Mochila térmica en mal estado.\n");
            this.cancelar();
            return false;
        }

        System.out.println("[OK] Mochila térmica en buen estado.\n");
        return true;
    }

    @Override
    protected int calcularTiempoEntrega() {
        return (int) (15 + 2 * getDistanciaKm());
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Buscando un repartidor disponible para un pedido de comida...");
    }

    public void setMochilaEnBuenEstado(boolean mochilaEnBuenEstado) {
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }
}
