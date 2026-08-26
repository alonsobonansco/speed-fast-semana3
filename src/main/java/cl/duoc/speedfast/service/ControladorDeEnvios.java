package cl.duoc.speedfast.service;

import cl.duoc.speedfast.model.Cancelable;
import cl.duoc.speedfast.model.PedidoComida;
import cl.duoc.speedfast.model.Rastreable;
import cl.duoc.speedfast.model.Reservable;
import cl.duoc.speedfast.strategy.DespachoMoto;

public class ControladorDeEnvios implements Cancelable, Rastreable, Reservable {

    public ControladorDeEnvios() {
        /*PedidoComida pedidoComida = new PedidoComida(
                "001", "calle 123", 14.0,
                new DespachoMoto(), true);
        pedidoComida.mostrarResumen();*/
    }


    @Override
    public void cancelar() {

    }

    @Override
    public void verHistorial() {

    }

    @Override
    public void reservar() {

    }
}
