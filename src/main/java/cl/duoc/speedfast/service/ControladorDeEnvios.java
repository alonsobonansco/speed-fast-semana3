package cl.duoc.speedfast.service;

import cl.duoc.speedfast.model.Pedido;
import cl.duoc.speedfast.model.Rastreable;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de la gestión, almacenamiento y auditoría de los pedidos.
 * Centraliza el historial general del sistema y coordina el reporte de la bitácora.
 */
public class ControladorDeEnvios implements Rastreable {
    private final List<Pedido> historialPedidos = new ArrayList<>();

    /**
     * Orquesta de forma automática las fases iniciales del ciclo operativo de un pedido.
     *
     * @param pedido           El objeto pedido.
     * @param nombreRepartidor El nombre del repartidor asignado.
     */
    public void procesarDespacho(Pedido pedido, String nombreRepartidor) {
        if (pedido == null) return;

        pedido.mostrarResumen();
        pedido.asignarRepartidor();
        pedido.asignarRepartidor(nombreRepartidor);

        if (pedido.validarPedido()) {
            pedido.despachar();
        }
    }

    /**
     * Registra un pedido en el historial general de la aplicación.
     *
     * @param pedido El objeto pedido que se desea registrar.
     */
    public void registrarEstadoPedido(Pedido pedido) {
        if (pedido != null) {
            this.historialPedidos.add(pedido);
        }
    }

    @Override
    public void verHistorial() {
        if (historialPedidos.isEmpty()) {
            System.out.println("No se han registrado pedidos en esta sesión.");
            return;
        }

        String tituloHistorial = """
                \n======================================
                === HISTORIAL DE TODAS LAS ÓRDENES ===
                ======================================\n""";
        System.out.println(tituloHistorial);

        for (Pedido pedido : historialPedidos) {
            if (pedido.isPedidoActivo()) {
                System.out.println("- " + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + " - entregado por " + pedido.getNombreRepartidor());
            } else {
                System.out.println("- " + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + " - [Orden cancelada]");
            }
        }
    }
}
