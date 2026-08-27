package cl.duoc.speedfast.service;

import cl.duoc.speedfast.model.*;
import cl.duoc.speedfast.strategy.DespachoAuto;
import cl.duoc.speedfast.strategy.DespachoCamion;
import cl.duoc.speedfast.strategy.DespachoMoto;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios {

    private final List<String> historialAcciones;
    private Pedido pedidoActual;
    private final List<Pedido> pedidosPrueba;

    public ControladorDeEnvios() {
        this.historialAcciones = new ArrayList<>();
        this.pedidosPrueba = new ArrayList<>();

        pedidosPrueba.add(new PedidoComida(
                "001", "Avenida Alemania 456", 5.2, new DespachoMoto(), true));
        pedidosPrueba.add(new PedidoExpress(
                "002", "Calle Limache 789", 12.8, new DespachoAuto()));
        pedidosPrueba.add(new PedidoEncomienda(
                "003", "calle 123", 14.0,
                new DespachoCamion(), 34.0));
    }

    public void ejecutarDemostracion() {
        Pedido p1 = pedidosPrueba.get(0);
        Pedido p2 = pedidosPrueba.get(1);
        Pedido p3 = pedidosPrueba.get(2);

        p1.mostrarResumen();
        p1.asignarRepartidor();
        p1.asignarRepartidor("Roberto");
        p1.validarPedido();
        p1.despachar();
        System.out.println("Condiciones climáticas obligan a cambiar de vehículo de despacho...");
        p1.setEstrategiaDespacho(new DespachoAuto());
        p1.despachar();

        p2.mostrarResumen();
        p2.cancelar();
        p2.cancelar();

        p3.mostrarResumen();
        p3.asignarRepartidor();
        p3.asignarRepartidor("Luciano");
        p3.validarPedido();
        p3.despachar();
    }
}
