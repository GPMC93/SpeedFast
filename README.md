# SpeedFast - Semana 5

## Descripción

Proyecto desarrollado en Java para simular la gestión concurrente de pedidos de SpeedFast.

En esta semana se incorporó una zona de carga compartida por varios repartidores, utilizando sincronización para evitar que un mismo pedido sea retirado por más de un hilo al mismo tiempo.

## Conceptos aplicados

- Programación orientada a objetos.
- Herencia y clases abstractas.
- Interfaces.
- Enum para representar estados de los pedidos.
- Runnable para representar tareas concurrentes.
- ExecutorService para ejecutar varios repartidores.
- Thread.sleep() para simular tiempos de entrega.
- synchronized para proteger el acceso a recursos compartidos.
- Manejo de InterruptedException.

## Estados del pedido

Los pedidos pueden tener los siguientes estados:

- PENDIENTE
- EN_REPARTO
- ENTREGADO

Cada pedido comienza automáticamente con estado PENDIENTE.

## Zona de carga

La clase `ZonaDeCarga` almacena los pedidos disponibles.

Los métodos para agregar y retirar pedidos utilizan `synchronized`, evitando que dos repartidores puedan retirar el mismo pedido simultáneamente.

## Repartidores

Cada repartidor implementa la interfaz `Runnable`.

Los repartidores comparten una misma instancia de `ZonaDeCarga`, retiran pedidos disponibles y realizan las entregas de manera concurrente.

Durante la entrega, el estado del pedido cambia de:

PENDIENTE → EN_REPARTO → ENTREGADO

## Ejecución concurrente

Se utiliza un `ExecutorService` con tres hilos para ejecutar simultáneamente a tres repartidores.

El programa espera a que todos los repartidores terminen antes de finalizar la ejecución.

## Resultado

La simulación permite procesar todos los pedidos de forma concurrente, evitando retiros duplicados mediante sincronización y finalizando cuando todos los pedidos han sido entregados.