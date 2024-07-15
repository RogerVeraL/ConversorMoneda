import java.util.Scanner;

// Clase principal que maneja la lógica de la aplicación
public class ConversorApp {

    public static void main(String[] args) {
        double cantidad;
        int opcion;
        Scanner scanner = new Scanner(System.in);
        ConexionConsulta conexionConsulta = new ConexionConsulta();

        String menu = """
                Bienvenido al conversor de monedas
                Seleccione una opción:
                1. Peso colombiano -> Dolar
                2. Peso colombiano -> Euro
                3. Peso colombiano -> Yen
                4. Dolar -> Peso colombiano
                5. Euro -> Peso colombiano
                6. Yen -> Peso colombiano
                7. Dolar -> Euro
                8. Euro -> Dolar
                0. Salir

                Selecciona una opción:""";

        do {
            System.out.println(menu);
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.\n");
                scanner.next();
            }
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Ingrese la cantidad a convertir:");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Por favor, ingrese una cantidad válida.\n");
                    scanner.next();
                }
                cantidad = scanner.nextDouble();
                realizarConversion(conexionConsulta, opcion, cantidad);
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida, por favor intente de nuevo.\n");
            }

        } while (opcion != 0);

        System.out.println("FIN DEL PROGRAMA");
        scanner.close();
    }

    private static void realizarConversion(ConexionConsulta conexionConsulta, int opcion, double cantidad) {
        String[][] conversiones = {
                {"COP", "USD"},
                {"COP", "EUR"},
                {"COP", "JPY"},
                {"USD", "COP"},
                {"EUR", "COP"},
                {"JPY", "COP"},
                {"USD", "EUR"},
                {"EUR", "USD"}
        };

        String base = conversiones[opcion - 1][0];
        String destino = conversiones[opcion - 1][1];

        Conversion datos = conexionConsulta.consultar(base, destino, cantidad);
        System.out.println(datos.resultados(base, destino, cantidad));
    }
}