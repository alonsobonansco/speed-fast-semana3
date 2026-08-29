package cl.duoc.speedfast.model;

import cl.duoc.speedfast.strategy.DespachoStrategy;

/**
 * Clase genérica de un pedido y superclase de subtipos de pedidos.
 */
public abstract class Pedido implements Despachable, Cancelable {
    private final String tipoPedido;
    private final String idPedido;
    private String direccionEntrega;
    private final double distanciaKm;
    private boolean pedidoActivo = true;
    private DespachoStrategy estrategiaDespacho;
    private String nombreRepartidor = "No asignado";

    /**
     * Constructor que inicializa el estado base e inmutable de un pedido para las subclases.
     *
     * @param tipoPedido         Tipo de pedido.
     * @param idPedido           Identificador único de la orden.
     * @param direccionEntrega   Destino físico del despacho.
     * @param distanciaKm        Trayecto en kilómetros.
     * @param estrategiaDespacho Estrategia que recibe para despachar.
     * @throws IllegalArgumentException Si el idPedido o la direccionEntrega están vacíos, o si
     *                                  la distancia es menor o igual a cero.
     */
    public Pedido(String tipoPedido, String idPedido, String direccionEntrega, double distanciaKm, DespachoStrategy estrategiaDespacho) {
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
        this.estrategiaDespacho = estrategiaDespacho;
    }

    /**
     * Ejecuta el despacho del pedido utilizando la estrategia de transporte asignada.
     * Protege el flujo mediante una cláusula de guarda que impide enviar órdenes canceladas.
     */
    @Override
    public void despachar() {
        if (!pedidoActivo) {
            System.out.println("No se puede despachar un pedido cancelado.\n");
            return;
        }
        estrategiaDespacho.despacharPedido(this);
    }

    /**
     * Permite intercambiar la estrategia de despacho en tiempo de ejecución.
     *
     * @param estrategiaDespacho La nueva estrategia de despacho a inyectar en el pedido.
     */
    public void setEstrategiaDespacho(DespachoStrategy estrategiaDespacho) {
        this.estrategiaDespacho = estrategiaDespacho;
    }

    /**
     * Cancela el pedido actual modificando su estado interno a falso.
     * Cuenta con un escudo defensivo que bloquea solicitudes de anulación duplicadas.
     */
    @Override
    public void cancelar() {
        if (!pedidoActivo) {
            System.out.println("- El pedido #" + idPedido + " ya se encuentra cancelado.\n");
            return;
        }
        pedidoActivo = false;
        System.out.println("- El pedido #" + idPedido + " ha sido cancelado.\n");
    }

    /**
     * Evalúa si las condiciones operativas de la subclase permiten el envío.
     * Cada tipo de pedido implementa sus propias reglas de negocio.
     *
     * @return true si el pedido pasa los controles; false si es rechazado.
     */
    public abstract boolean validarPedido();

    /**
     * Calcula el tiempo estimado que tardará el reparto en llegar al destino.
     * Cada subclase implementa su propia lógica de estimación.
     *
     * @return Tiempo estimado para la entrega en minutos.
     */
    protected abstract int calcularTiempoEntrega();

    public abstract void asignarRepartidor();

    /**
     * Realiza la asignación manual del repartidor en el sistema. Guarda el nombre
     * recibido en la memoria de la clase.
     *
     * @param nombreRepartidor El nombre del transportista que hará el reparto del pedido.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
        System.out.println("[" + tipoPedido + " #" + idPedido + "] asignado a " + nombreRepartidor + ".\n");
    }

    public void mostrarResumen() {
        String textoResumen = """
                \n===================
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

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        if (direccionEntrega == null || direccionEntrega.isBlank()) {
            throw new IllegalArgumentException("La dirección de entrega debe ser válida.");
        }
        this.direccionEntrega = direccionEntrega;
    }

    public boolean isPedidoActivo() {
        return pedidoActivo;
    }
}
