package cl.duoc.speedfast.service;

import cl.duoc.speedfast.model.*;
import cl.duoc.speedfast.strategy.DespachoAuto;
import cl.duoc.speedfast.strategy.DespachoCamion;
import cl.duoc.speedfast.strategy.DespachoMoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de la gestión, almacenamiento y auditoría de los pedidos.
 * Centraliza el historial general del sistema y coordina el reporte de la bitácora.
 */
public class ControladorDeEnvios implements Rastreable {
    private final List<Pedido> historialPedidos = new ArrayList<>();

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
