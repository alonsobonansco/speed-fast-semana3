package cl.duoc.speedfast.model;

public class PedidoEncomienda extends Pedido {

    private static final double CAPACIDAD_MAXIMA_KG = 40.0;
    private final double pesoEncomienda;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, double pesoEncomienda) {
        super("PEDIDO ENCOMIENDA", idPedido, direccionEntrega, distanciaKm);

        if (pesoEncomienda <= 0) {
            throw new IllegalArgumentException("El peso de la encomienda debe ser válido.");
        }
        this.pesoEncomienda = pesoEncomienda;
    }

    protected int calcularTiempoEntrega() {
        return -1;
    }

    protected void asignarRepartidor() {

    }

    protected void asignarRepartidor(String nombreRepartidor) {

    }
}
