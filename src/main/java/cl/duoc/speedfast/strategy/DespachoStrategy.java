package cl.duoc.speedfast.strategy;

import cl.duoc.speedfast.model.Pedido;

/**
 * Interfaz base para aplicar el patrón Strategy.
 * Define el contrato único para todos los algoritmos de transporte del sistema.
 */
public interface DespachoStrategy {
    /**
     * Ejecuta el despacho de una orden utilizando el vehículo activo.
     *
     * @param pedido El objeto pedido que contiene la información de la ruta en la RAM.
     */
    void despacharPedido(Pedido pedido);
}
