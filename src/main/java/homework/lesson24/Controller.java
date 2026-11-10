package homework.lesson24;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

public class Controller {
    private static final String BORED_API = "https://www.boredapi.com/api/activity";
    private static final String JOKE_API = "https://official-joke-api.appspot.com/random_joke";

    public void runApp() {
        boolean isRunning = true;
        HttpClient client = buildClient();
        HttpRequest requestBoredApi = buildRequestBoredApi();
        HttpRequest requestJokeApi = buildRequestJokeApi();

        while (isRunning) {
            HttpResponse<String> responseBoredApi = getResponseBoredApi(client, requestBoredApi);
            String responseJokeApi = getResponseJokeApi(client, requestJokeApi);
            if (responseJokeApi != null) {
                writeResponseToFile(responseJokeApi);
            }
            if (responseBoredApi != null) {
                System.out.println(responseBoredApi.statusCode());
                System.out.println(responseBoredApi.body());
            }
            try {
                Thread.sleep(Duration.ofSeconds(10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(e.getMessage());
            }
        }
    }

    private HttpRequest buildRequestBoredApi() {
        return HttpRequest.newBuilder().uri(URI.create(BORED_API)).timeout(Duration.ofSeconds(10)).GET().build();
    }

    private HttpRequest buildRequestJokeApi() {
        return HttpRequest.newBuilder(URI.create(JOKE_API)).timeout(Duration.ofSeconds(10)).GET().build();
    }

    private HttpClient buildClient() {
        return HttpClient.newHttpClient();
    }

    private HttpResponse<String> getResponseBoredApi(HttpClient client, HttpRequest request) {
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
        return null;
    }

    private String getResponseJokeApi(HttpClient client, HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return "Status: " + response.statusCode() + "\n" +
                    response.body() + "\n";
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
        return null;
    }

    private void writeResponseToFile(String response) {
        try {
            Files.writeString(Path.of("responses.txt"), response, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
