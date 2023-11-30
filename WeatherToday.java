import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class WeatherToday {
    final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url("https://weatherapi-com.p.rapidapi.com/current.json?q=24515")
                .get()
                .addHeader("X-RapidAPI-Key", "REDACTED")
                .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    //Weather Constructor


    String location(WeatherToday w) throws IOException {
        String weatherResponse = w.run("https://raw.github.com/square/okhttp/master/README.md");
        JSONObject json = new JSONObject(weatherResponse);
        JSONObject location = json.getJSONObject("location");
        String currentLocation = "Your current locaton is: " + location.getString("name") +
                ", " + location.getString("region") +
                ", " + location.getString("country");
        JSONObject currentCondition = json.getJSONObject("current");
        String actualTemp = currentCondition.getBigDecimal("temp_f").toString();
        String feelsLiketemp = currentCondition.getBigDecimal("feelslike_f").toString();
        String temp = "Current temperature in Fahrenheit: " + actualTemp +
                "\n" + "Current real feel temperature in Fahrenheit: " + feelsLiketemp;

        return currentLocation + "\n" + temp;
    }
}





