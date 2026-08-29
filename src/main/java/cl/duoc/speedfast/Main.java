package cl.duoc.speedfast;

import cl.duoc.speedfast.model.Pedido;
import cl.duoc.speedfast.model.PedidoComida;
import cl.duoc.speedfast.model.PedidoEncomienda;
import cl.duoc.speedfast.model.PedidoExpress;
import cl.duoc.speedfast.service.ControladorDeEnvios;
import cl.duoc.speedfast.strategy.DespachoAuto;
import cl.duoc.speedfast.strategy.DespachoCamion;
import cl.duoc.speedfast.strategy.DespachoMoto;

/**
 * Punto de entrada de la aplicación SpeedFast.
 * Actúa como el entorno de ejecución y pruebas para simular
 * el comportamiento secuencial de los flujos de despacho en la consola.
 */
public class Main {
    public static void main(String[] args) {
        ControladorDeEnvios gestor = new ControladorDeEnvios();

        Pedido pedidoComida = new PedidoComida(
                "001", "Avenida Alemania 456", 5.2, new DespachoMoto(), true);
        Pedido pedidoExpress = new PedidoExpress(
                "002", "Calle Limache 789", 12.8, new DespachoAuto());
        Pedido pedidoEncomienda = new PedidoEncomienda(
                "003", "Calle Principal 123", 14.0,
                new DespachoCamion(), 84.0);

        // PROCESAMIENTO PEDIDO COMIDA #001 (CON CAMBIO DE ESTRATEGIA)
        gestor.procesarDespacho(pedidoComida, "Roberto");

        System.out.println("[Condiciones climáticas obligan a cambiar de vehículo de despacho...]\n");

        // La estrategia cambia de Moto a Auto
        pedidoComida.setEstrategiaDespacho(new DespachoAuto());
        pedidoComida.despachar();
        gestor.registrarEstadoPedido(pedidoComida);

        // PROCESAMIENTO PEDIDO EXPRESS #002
        gestor.procesarDespacho(pedidoExpress, "Mario");
        gestor.registrarEstadoPedido(pedidoExpress);

        // PROCESAMIENTO PEDIDO ENCOMIENDA #003 (CON CANCELACIÓN)
        // La cancelación ocurre internamente al (validarPedido) y este no pasa el control
        gestor.procesarDespacho(pedidoEncomienda, "Luciano");
        gestor.registrarEstadoPedido(pedidoEncomienda);

        // HISTORIAL DEL ESTADO DE TODOS LOS PEDIDOS
        gestor.verHistorial();
    }
}
