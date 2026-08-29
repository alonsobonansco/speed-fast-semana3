package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

/**
 * Subclase de Pedido. Sus atributos son CAPACIDAD_MAXIMA y pesoEncomienda. El primero es
 * el valor máximo permitido para el transporte y el personal, el segundo es el peso real
 * de la encomienda a enviar.
 */
public class PedidoEncomienda extends Pedido {
    private static final double CAPACIDAD_MAXIMA_KG = 40.0;
    private final double pesoEncomienda;

    /**
     * Construye un pedido de encomienda.
     *
     * @param idPedido           Identificador único de la orden.
     * @param direccionEntrega   Destino físico del despacho.
     * @param distanciaKm        Trayecto en kilómetros.
     * @param estrategiaDespacho Estrategia que recibe para despachar.
     * @param pesoEncomienda     Peso de la encomienda en kilogramos.
     * @throws IllegalArgumentException Si el peso de la encomienda es menor o igual a cero.
     */
    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho, double pesoEncomienda) {
        super("PEDIDO ENCOMIENDA", idPedido, direccionEntrega, distanciaKm, estrategiaDespacho);

        if (pesoEncomienda <= 0) {
            throw new IllegalArgumentException("El peso de la encomienda debe ser válido.");
        }
        this.pesoEncomienda = pesoEncomienda;
    }

    @Override
    public boolean validarPedido() {
        System.out.println("Verificando que el peso de la encomienda no exceda el límite...");

        if (pesoEncomienda > CAPACIDAD_MAXIMA_KG) {
            System.out.println("[ERROR] El peso de la encomienda supera el límite permitido.\n");
            this.cancelar();
            return false;
        }

        System.out.println("[OK] Peso de la encomienda permitido.\n");
        return true;
    }

    @Override
    protected int calcularTiempoEntrega() {
        return (int) (20 + 1.5 * getDistanciaKm());
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Buscando un repartidor disponible para un pedido de encomienda...");
    }
}
