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
    static void main() {
        ControladorDeEnvios gestor = new ControladorDeEnvios();
        //estor.ejecutarDemostracion();

        Pedido pedidoComida = new PedidoComida(
                "001", "Avenida Alemania 456", 5.2, new DespachoMoto(), true);
        Pedido pedidoExpress = new PedidoExpress(
                "002", "Calle Limache 789", 12.8, new DespachoAuto());
        Pedido pedidoEncomienda = new PedidoEncomienda(
                "003", "Calle Principal 123", 14.0,
                new DespachoCamion(), 84.0);

        // ==========================================
        // PROCESAMIENTO PEDIDO #001 (COMIDA CON CAMBIO DE ESTRATEGIA)
        // ==========================================
        pedidoComida.mostrarResumen();
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Roberto");

        if (pedidoComida.validarPedido()) {
            pedidoComida.despachar();
        }

        System.out.println("Condiciones climáticas obligan a cambiar de vehículo de despacho...");
        pedidoComida.setEstrategiaDespacho(new DespachoAuto());
        pedidoComida.despachar();

        // ==========================================
        // PROCESAMIENTO PEDIDO #002 (EXPRESS CON CANCELACIÓN)
        // ==========================================
        pedidoExpress.mostrarResumen();
        pedidoExpress.cancelar();
        pedidoExpress.despachar();
        pedidoExpress.cancelar();

        // ==========================================
        // PROCESAMIENTO PEDIDO #003 (ENCOMIENDA)
        // ==========================================
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Luciano");

        if (pedidoEncomienda.validarPedido()) {
            pedidoEncomienda.despachar();
        }



    }
}
