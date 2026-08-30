# SpeedFast - Semana 3

Proyecto desarrollado en Java para practicar Programación Orientada a Objetos, utilizando herencia, abstracción, polimorfismo e interfaces.

## Descripción

El sistema simula distintos tipos de pedidos de la empresa SpeedFast:

- Pedido de comida
- Pedido de encomienda
- Pedido express

Cada tipo de pedido hereda de la clase abstracta `Pedido` y define su propio cálculo de tiempo de entrega.

Además, se utilizan interfaces para representar distintas capacidades de los pedidos:

- `Despachable`
- `Cancelable`
- `Rastreable`

## Conceptos aplicados

En este proyecto se utilizaron los siguientes conceptos:

- Clase abstracta
- Herencia
- Polimorfismo
- Sobrescritura de métodos
- Sobrecarga de métodos
- Interfaces
- ArrayList
- instanceof

## Polimorfismo

Los distintos tipos de pedidos se almacenan dentro de un:

```java
ArrayList<Pedido>