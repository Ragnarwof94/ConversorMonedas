import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ConversorMonedas {
    // Reemplaza "TU_API_KEY" con tu clave API real de ExchangeRate-API.com
    // Si estás ejecutando esto en el entorno de Canvas, deja esta cadena vacía.
    private static final String API_KEY = "c3f30ced55aece1dc451e12f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseCurrency = "USD"; // Moneda base predeterminada
        boolean running = true;

        System.out.println("¡Bienvenido al Conversor de Monedas!");

        while (running) {
            try {
                // Obtener las tasas de cambio para la moneda base actual
                JsonObject exchangeRates = fetchExchangeRates(baseCurrency);
                if (exchangeRates == null) {
                    System.out.println("No se pudieron obtener las tasas de cambio. Intentelo de nuevo más tarde.");
                    running = false; // Salir si no se pueden obtener las tasas
                    continue;
                }

                // Mostrar las monedas disponibles
                displayAvailableCurrencies(exchangeRates);

                // Solicitar la moneda de origen
                System.out.print("Ingrese la moneda de origen (ej. USD, EUR, JPY): ");
                String fromCurrency = scanner.nextLine().toUpperCase();

                // Verificar si la moneda de origen es válida
                if (!exchangeRates.has(fromCurrency)) {
                    System.out.println("Moneda de origen no válida. Por favor, intente de nuevo.");
                    continue;
                }

                // Solicitar la moneda de destino
                System.out.print("Ingrese la moneda de destino (ej. BRL, ARS, CLP): ");
                String toCurrency = scanner.nextLine().toUpperCase();

                // Verificar si la moneda de destino es válida
                if (!exchangeRates.has(toCurrency)) {
                    System.out.println("Moneda de destino no válida. Por favor, intente de nuevo.");
                    continue;
                }

                // Solicitar la cantidad a convertir
                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea para evitar problemas con la siguiente entrada

                // Realizar la conversión
                double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency, exchangeRates);
                System.out.printf("%.2f %s equivale a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

                System.out.print("¿Desea realizar otra conversión? (si/no): ");
                String continueOption = scanner.nextLine().toLowerCase();
                if (!continueOption.equals("si")) {
                    running = false;
                }

            } catch (IOException | InterruptedException e) {
                System.err.println("Error de comunicación con la API: " + e.getMessage());
                running = false;
            } catch (JsonSyntaxException e) {
                System.err.println("Error al parsear la respuesta JSON: " + e.getMessage());
                running = false;
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, ingrese un número para la cantidad.");
                scanner.nextLine(); // Limpiar el buffer del scanner para evitar bucles infinitos
            } catch (Exception e) {
                System.err.println("Ocurrió un error inesperado: " + e.getMessage());
                running = false;
            }
        }
        scanner.close();
        System.out.println("¡Gracias por usar el Conversor de Monedas!");
    }

    /**
     * Fetches the latest exchange rates from the API for a given base currency.
     * Obtiene las últimas tasas de cambio de la API para una moneda base dada.
     * @param baseCurrency The currency to use as the base for exchange rates.
     * La moneda a usar como base para las tasas de cambio.
     * @return A JsonObject containing the conversion rates, or null if an error occurs.
     * Un JsonObject que contiene las tasas de conversión, o null si ocurre un error.
     * @throws IOException If an I/O error occurs when sending or receiving.
     * Si ocurre un error de E/S al enviar o recibir.
     * @throws InterruptedException If the operation is interrupted.
     * Si la operación es interrumpida.
     * @throws JsonSyntaxException If the JSON response is malformed.
     * Si la respuesta JSON está mal formada.
     */
    private static JsonObject fetchExchangeRates(String baseCurrency) throws IOException, InterruptedException, JsonSyntaxException {
        // Construye la URI (dirección de internet) para la solicitud HTTP
        URI uri = URI.create(API_URL + baseCurrency);
        HttpClient client = HttpClient.newHttpClient(); // Crea un "cliente" para hacer solicitudes por internet
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri) // Establece la dirección (URI)
                .build(); // Construye la solicitud

        // Envía la solicitud y obtiene la respuesta del servidor
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica si la solicitud fue exitosa (código 200 OK significa que todo salió bien)
        if (response.statusCode() == 200) {
            Gson gson = new Gson(); // Crea una instancia de Gson (nuestro "ayudante" para JSON)
            // Parsea la respuesta JSON completa (convierte el texto JSON en un objeto Java que podemos usar)
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            // Extrae el objeto 'conversion_rates' que contiene todas las tasas de cambio
            return jsonResponse.getAsJsonObject("conversion_rates");
        } else {
            // Si hay un error, imprime el código de estado y el cuerpo de la respuesta para depuración
            System.err.println("Error al obtener las tasas de cambio. Código de estado: " + response.statusCode());
            System.err.println("Cuerpo de la respuesta: " + response.body());
            return null; // Devuelve null si hay un error
        }
    }

    /**
     * Displays a formatted list of available currencies from the exchange rates.
     * Muestra una lista formateada de las monedas disponibles a partir de las tasas de cambio.
     * @param exchangeRates The JsonObject containing the conversion rates.
     * El JsonObject que contiene las tasas de conversión.
     */
    private static void displayAvailableCurrencies(JsonObject exchangeRates) {
        System.out.println("\nMonedas disponibles para conversión:");
        Set<String> currencies = exchangeRates.keySet(); // Obtiene todos los nombres de las monedas
        // Ordena las monedas alfabéticamente y las imprime en columnas para una mejor lectura
        currencies.stream()
                .sorted() // Ordena alfabéticamente
                .collect(Collectors.groupingBy(s -> currencies.stream().collect(Collectors.toList()).indexOf(s) / 5)) // Agrupa en 5 columnas
                .values()
                .forEach(row -> {
                    row.forEach(currency -> System.out.printf("%-8s", currency)); // Imprime cada moneda con un formato de 8 espacios
                    System.out.println(); // Salto de línea para la siguiente fila de monedas
                });
        System.out.println("----------------------------------------");
    }

    /**
     * Converts an amount from one currency to another using the provided exchange rates.
     * Convierte una cantidad de una moneda a otra utilizando las tasas de cambio proporcionadas.
     * @param amount The amount to convert.
     * La cantidad a convertir.
     * @param fromCurrency The currency to convert from.
     * La moneda de la que se va a convertir.
     * @param toCurrency The currency to convert to.
     * La moneda a la que se va a convertir.
     * @param exchangeRates The JsonObject containing the conversion rates.
     * El JsonObject que contiene las tasas de conversión.
     * @return The converted amount.
     * La cantidad convertida.
     */
    private static double convertCurrency(double amount, String fromCurrency, String toCurrency, JsonObject exchangeRates) {
        // Obtener las tasas de cambio de las monedas seleccionadas
        double rateFrom = exchangeRates.get(fromCurrency).getAsDouble(); // Tasa de la moneda de origen
        double rateTo = exchangeRates.get(toCurrency).getAsDouble();     // Tasa de la moneda de destino

        // Calcular la cantidad convertida
        // La lógica es: (cantidad_original / tasa_de_origen_a_base) * tasa_de_destino_a_base
        // Por ejemplo, si USD es la base: (10 EUR / tasa_EUR_a_USD) * tasa_USD_a_JPY
        return (amount / rateFrom) * rateTo;
    }
}
