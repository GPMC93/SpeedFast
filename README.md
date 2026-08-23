# SpeedFast

Proyecto desarrollado en Java para la asignatura **Desarrollo Orientado a Objetos II**.

## Actividad 2 - Clases abstractas y herencia

El proyecto simula distintos tipos de pedidos de la empresa SpeedFast y calcula el tiempo estimado de entrega según el tipo de pedido y la distancia recorrida.

## Estructura del proyecto

El proyecto utiliza una clase abstracta principal llamada `Pedido` y tres clases derivadas:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

La clase `Pedido` contiene los atributos comunes:

- ID del pedido
- Dirección de entrega
- Distancia en kilómetros

También contiene el método `mostrarResumen()` y define el método abstracto `calcularTiempoEntrega()`.

## Cálculo de tiempos de entrega

Cada tipo de pedido implementa su propia lógica:

### PedidoComida

15 minutos base + 2 minutos por cada kilómetro.

### PedidoEncomienda

20 minutos base + 1.5 minutos por cada kilómetro.

### PedidoExpress

10 minutos base.  
Si la distancia es mayor a 5 km, se agregan 5 minutos adicionales.

## Conceptos de Programación Orientada a Objetos utilizados

- Abstracción
- Herencia
- Sobrescritura de métodos
- Polimorfismo
- Encapsulamiento
- Clases y objetos
- Constructores
- Getters y setters
- Colecciones con `ArrayList`

## Ejemplo de ejecución

```text
PedidoComida #1
Dirección: Av. Italia 456
Distancia: 4.0 km
Tiempo estimado de entrega: 23 minutos

PedidoEncomienda #2
Dirección: Av. Independencia 123
Distancia: 6.0 km
Tiempo estimado de entrega: 29 minutos

PedidoExpress #3
Dirección: Av. Apoquindo 1500
Distancia: 7.0 km
Tiempo estimado de entrega: 15 minutos