// Clase que representa la conversión de moneda
class Conversion {
    private final double conversionRate;
    private final double result;

    public Conversion(double conversionRate, double result) {
        this.conversionRate = conversionRate;
        this.result = result;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getResult() {
        return result;
    }

    public String resultados(String base, String destino, double cantidad) {
        return String.format(
                """
                Tasa de conversión 1 %s -> %s: %s
                Conversión de %.2f %s -> %s %s
                """,
                base, conversionRate, destino,
                cantidad, base, result, destino
        );
    }
}