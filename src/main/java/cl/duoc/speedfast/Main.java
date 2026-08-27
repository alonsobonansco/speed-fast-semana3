package cl.duoc.speedfast;

import cl.duoc.speedfast.model.Pedido;
import cl.duoc.speedfast.model.PedidoComida;
import cl.duoc.speedfast.model.PedidoEncomienda;
import cl.duoc.speedfast.model.PedidoExpress;
import cl.duoc.speedfast.service.ControladorDeEnvios;
import cl.duoc.speedfast.strategy.DespachoAuto;
import cl.duoc.speedfast.strategy.DespachoCamion;
import cl.duoc.speedfast.strategy.DespachoMoto;

public class Main {
    public static void main(String[] args) {
        ControladorDeEnvios gestor = new ControladorDeEnvios();
        //estor.ejecutarDemostracion();

        Pedido pedidoComida = new PedidoComida(
                "001", "Avenida Alemania 456", 5.2, new DespachoMoto(), true);
        Pedido pedidoExpress = new PedidoExpress(
                "002", "Calle Limache 789", 12.8, new DespachoAuto());
        Pedido pedidoEncomienda = new PedidoEncomienda(
                "003", "Calle Principal 123", 14.0,
                new DespachoCamion(), 84.0);


        // PROCESAMIENTO PEDIDO COMIDA #001 (CON CAMBIO DE ESTRATEGIA)
        pedidoComida.mostrarResumen();
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Roberto");

        if (pedidoComida.validarPedido()) {
            pedidoComida.despachar();
        }

        System.out.println("[Condiciones climáticas obligan a cambiar de vehículo de despacho...]\n");
        // La estrategia cambia de Moto a Auto
        pedidoComida.setEstrategiaDespacho(new DespachoAuto());
        pedidoComida.despachar();
        gestor.registrarEstadoPedido(pedidoComida);


        // PROCESAMIENTO PEDIDO EXPRESS #002
        pedidoExpress.mostrarResumen();
        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Mario");

        if (pedidoExpress.validarPedido()) {
            pedidoExpress.despachar();
        }

        gestor.registrarEstadoPedido(pedidoExpress);


        // PROCESAMIENTO PEDIDO ENCOMIENDA #003 (CON CANCELACIÓN)
        // La cancelación ocurre internamente al (validarPedido) y este no pasa el control
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Luciano");

        if (pedidoEncomienda.validarPedido()) {
            pedidoEncomienda.despachar();
        }

        gestor.registrarEstadoPedido(pedidoEncomienda);

        // HISTORIAL DEL ESTADO DE TODOS LOS PEDIDOS
        gestor.verHistorial();

    }
}
