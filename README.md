# SpeedFast - Semana 4

Proyecto desarrollado en Java para aplicar conceptos de Programación Orientada a Objetos y programación concurrente.

## Descripción

SpeedFast es un sistema que simula la gestión y entrega de distintos tipos de pedidos:

- Pedido de comida
- Pedido de encomienda
- Pedido express

El proyecto reutiliza la estructura orientada a objetos desarrollada anteriormente e incorpora concurrencia para simular a varios repartidores realizando entregas al mismo tiempo.

## Conceptos aplicados

- Clase abstracta
- Herencia
- Polimorfismo
- Sobrescritura de métodos
- Sobrecarga de métodos
- Interfaces
- ArrayList
- Runnable
- Thread.sleep()
- ExecutorService
- Manejo de InterruptedException

## Pedidos

La clase abstracta `Pedido` contiene los atributos y comportamientos comunes de los pedidos.

Las clases:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

heredan de `Pedido` e implementan sus comportamientos específicos.

## Interfaces

Se utilizan las interfaces:

- `Despachable`
- `Cancelable`
- `Rastreable`

Estas permiten representar distintas capacidades de los pedidos.

## Concurrencia

La clase `Repartidor` implementa la interfaz `Runnable`.

Cada repartidor posee un nombre y una lista de pedidos asignados. Dentro del método `run()` recorre sus pedidos y simula el tiempo necesario para realizar cada entrega mediante `Thread.sleep()` con tiempos aleatorios.

## Ejecución concurrente

En `Main` se crean tres repartidores:

- Camila
- Luis
- Daniel

Cada repartidor recibe dos pedidos.

Para ejecutar las tareas concurrentemente se utiliza `ExecutorService` con un pool de tres hilos:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);