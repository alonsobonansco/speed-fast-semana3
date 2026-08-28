🚚 Speed Fast App
---  
Actividad sumativa 1 (Semana 3)

## 📖 Descripción

Este proyecto es una aplicación desarrollada en Java y Maven que simula el flujo logístico de una empresa de reparto a
domicilio. El objetivo principal es resolver el control de los pedidos y la asignación de vehículos de forma modular,
aplicando el **Patrón de Diseño Strategy** para cambiar los métodos de envío en tiempo de ejecución.

---

## 🚀 Cómo funciona el Patrón Strategy en el Proyecto

El patrón Strategy se utiliza para que las clases que representan a los pedidos no queden amarradas a un único tipo de
vehículo, permitiendo cambiar el transporte en ejecución dependiendo de las condiciones.

El flujo de datos en la memoria opera bajo tres reglas:

1. **El Pedido tiene la Estrategia:** La superclase `Pedido` guarda una referencia a la interfaz `DespachoStrategy`.
   Esto permite que cada objeto individual maneje su propio vehículo y exponga el método `setEstrategiaDespacho()`.
2. **Uso del parámetro `this`:** Al llamar al método `.despachar()`, el pedido se envía a sí mismo como argumento hacia
   la estrategia activa mediante la línea `estrategiaDespacho.despacharPedido(this)`.
3. **Estrategias sin atributos propios:** Las clases concretas (`DespachoMoto`, `DespachoCamion`, `DespachoAuto`) no
   guardan variables internas. Solo reciben el pedido por parámetro y ejecutan la impresión, optimizando el uso de la
   memoria RAM.

---

## 📂 Estructura del Proyecto:

```text
speed-fast-semana-3/
└── src/
    └── main/
        └── java/                           
            └── cl/
                └── speedfast/                       
                    ├── Main.java                    # Ejecución y pruebas secuenciales
                    ├── interfaces/                  # Contratos de comportamiento
                    │   ├── Cancelable.java
                    │   ├── Despachable.java
                    │   ├── Reservable.java
                    │   └── Rastreable.java
                    ├── service/                     # Encargado de gestionar la List única
                    │   └── ControladorDeEnvios.java  
                    ├── strategy/                    # Clases del Patrón Strategy
                    │   ├── DespachoStrategy.java    
                    │   ├── DespachoAuto.java        
                    │   ├── DespachoCamion.java      
                    │   └── DespachoMoto.java        
                    └── model/                       # Clases del dominio
                        ├── Pedido.java              - Superclase
                        ├── PedidoComida.java        
                        ├── PedidoEncomienda.java    
                        └── PedidoExpress.java       
```

---

### 🛠️ Instrucciones para clonar y ejecutar

Requisitos del sistema:

* **JDK:** Java 25 (LTS) o superior

1. Clonar el repositorio desde la terminal de la computadora o IDE:  
   git clone https://github.com/alonsobonansco/speed-fast-semana3.git
2. Ir a File →️ Open y seleccionar la carpeta raíz del proyecto (la carpeta que contiene el archivo pom.xml).
3. Ejecutar el `Main` desde su clase en el paquete raíz `cl.duoc.speedfast`

---

### Autor:

Alonso Antonio Bonansco Vergara  
Desarrollo Orientado a Objetos II - 004A  
Analista Programador Computacional