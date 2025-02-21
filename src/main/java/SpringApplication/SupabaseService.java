package SpringApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SupabaseService {

    private static final String SUPABASE_API_URL = "https://wxeseejwtrlkyitubugy.supabase.co/rest/v1";
    private static final String API_KEY = System.getenv("SUPABASE_API_KEY");

    public void getDataFromSupabase() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Przykładowe zapytanie do API Supabase
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(SUPABASE_API_URL + "/your_table"))
                .header("apikey", API_KEY)
                .header("Authorization", "Bearer " + API_KEY)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response from Supabase: " + response.body());
    }
}
