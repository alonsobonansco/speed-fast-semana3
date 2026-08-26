package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

public class PedidoEncomienda extends Pedido {

    private static final double CAPACIDAD_MAXIMA_KG = 40.0;
    private final double pesoEncomienda;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho, double pesoEncomienda) {
        super("PEDIDO ENCOMIENDA", idPedido, direccionEntrega, distanciaKm, estrategiaDespacho);

        if (pesoEncomienda <= 0) {
            throw new IllegalArgumentException("El peso de la encomienda debe ser válido.");
        }
        this.pesoEncomienda = pesoEncomienda;
    }

    @Override
    protected boolean validarPedido() {
        System.out.println("Verificando que el peso de la encomienda no exceda el límite...");

        if (pesoEncomienda > CAPACIDAD_MAXIMA_KG) {
            System.out.println("[ERROR] El peso de la encomienda supera el límite permitido.\n");
            return false;
        }

        System.out.println("[OK] Peso de la encomienda permitido.\n");
        return true;
    }

    protected int calcularTiempoEntrega() {
        return (int) (20 + 1.5 * getDistanciaKm());
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
