# SpeedFast

Proyecto desarrollado para la asignatura Desarrollo Orientado a Objetos II.

## Descripción

SpeedFast es un sistema simple de gestión de pedidos que permite representar distintos tipos de entregas:

- Pedido de comida
- Pedido de encomienda
- Pedido express

Cada tipo de pedido aplica reglas diferentes para la asignación de repartidores.

## Conceptos aplicados

- Herencia
- Interfaces
- Sobrescritura de métodos
- Sobrecarga de métodos
- Polimorfismo
- ArrayList
- Encapsulamiento

## Estructura principal

- `Pedido`: clase base.
- `PedidoComida`: clase derivada para pedidos de comida.
- `PedidoEncomienda`: clase derivada para encomiendas.
- `PedidoExpress`: clase derivada para pedidos express.
- `Asignable`: interfaz para definir el comportamiento de asignación.
- `Main`: prueba el funcionamiento del sistema y demuestra polimorfismo y sobrecarga.

## Ejecución

El programa muestra en consola la asignación de repartidores según el tipo de pedido y las validaciones específicas de cada caso.