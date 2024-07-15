# Conversor de Monedas

Este proyecto es una aplicación de consola en Java que permite convertir entre diferentes monedas usando la API de ExchangeRate-API. La aplicación soporta conversiones entre Peso Colombiano (COP), Dólar Estadounidense (USD), Euro (EUR) y Yen Japonés (JPY).

## Características

- Conversión entre Peso Colombiano (COP) y otras monedas (USD, EUR, JPY).
- Conversión desde USD, EUR y JPY hacia Peso Colombiano (COP).
- Consulta en tiempo real de tasas de conversión usando ExchangeRate-API.

## Requisitos

- Java
- Biblioteca [Gson](https://github.com/google/gson) para el manejo de JSON

## Instalación

1. Clona este repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tuusuario/conversor-monedas.git

## Estructura del Código

  - ConversorApp.java: Clase principal que maneja la lógica de la aplicación y la interacción con el usuario.
  - Conversion.java: Clase que representa la conversión de moneda y contiene los métodos para formatear los resultados.
  - ConexionConsulta.java: Clase que maneja la consulta a la API de ExchangeRate para obtener las tasas de conversión.

## Autor
- Roger Vera Londoño
