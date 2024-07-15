// Clase que maneja la consulta a la API de conversión de moneda
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class ConexionConsulta {

    public Conversion consultar(String base, String destino, double cantidad) {
        try {
            String API_KEY = "74670e9085d0bd6cdd56eb83";
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + destino + "/" + cantidad);

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            double conversionResult = jsonObject.get("conversion_result").getAsDouble();

            return new Conversion(conversionRate, conversionResult);

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API de conversión", e);
        }
    }
}