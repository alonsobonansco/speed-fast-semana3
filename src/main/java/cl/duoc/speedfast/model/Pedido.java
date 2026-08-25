package cl.duoc.speedfast.model;

public abstract class Pedido {

    /*public void mostrarResumen() {
        System.out.println("asdf");
    }*/

    protected abstract void calcularTiempoEntrega();

    protected abstract void asignarRepartidor();

    protected abstract void asignarRepartidor(String nombreRepartidor);
}
