package es.thalesalv.ibmtest.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import es.thalesalv.ibmtest.model.Movie;

public class Json {
    public static List<Movie> listFromUrl(String sUrl) throws Exception {
        URL url = new URL(sUrl);
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        String sJson = response.toString();
        JSONArray jMovies = new JSONObject(sJson).optJSONArray("data");
        return new Gson().fromJson(jMovies.toString(), new TypeToken<List<Movie>>() {}.getType());
    }
}