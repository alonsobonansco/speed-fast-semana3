package cl.duoc.speedfast.model;

public abstract class Pedido {
    private final String tipoPedido;
    private final String idPedido;
    private String direccionEntrega;
    private final double distanciaKm;

    public Pedido(String tipoPedido, String idPedido, String direccionEntrega, double distanciaKm) {
        if (idPedido == null || idPedido.isBlank()) {
            throw new IllegalArgumentException("El ID del pedido no puede estar vacío.");
        }
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("La distancia debe ser válida.");
        }
        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        setDireccionEntrega(direccionEntrega);
        this.distanciaKm = distanciaKm;

    }

    protected abstract boolean validarPedido();

    protected abstract int calcularTiempoEntrega();

    protected abstract void asignarRepartidor();

    protected abstract void asignarRepartidor(String nombreRepartidor);

    public void mostrarResumen() {
        String textoResumen = """
                ===================
                %s #%s
                ===================
                
                Dirección: %s
                Distancia: %.1f km
                Tiempo estimado de entrega: %d minutos
                """.formatted(
                getTipoPedido(), getIdPedido(),
                getDireccionEntrega(),
                getDistanciaKm(),
                calcularTiempoEntrega()
        );

        System.out.println(textoResumen);
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        if (direccionEntrega == null || direccionEntrega.isBlank()) {
            throw new IllegalArgumentException("La dirección de entrega debe ser válida.");
        }
        this.direccionEntrega = direccionEntrega;
    }
}
