package com.example.portfolio;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class GeocodeController {
    @RequestMapping(path = "/gethome", method = RequestMethod.GET )
    public String getGeocode() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String homeAddress = "Pieter Cheeuwenlaan 52,Beverwijk";
        String encodedAddress = URLEncoder.encode(homeAddress, "UTF-8");
        Request request = new Request.Builder()
                .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress)
                .get()
                .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "")
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        return responseBody.string();
    }
}