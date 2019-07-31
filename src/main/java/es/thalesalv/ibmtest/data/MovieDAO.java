package es.thalesalv.ibmtest.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.thalesalv.ibmtest.model.Movie;

public class MovieDAO {

	private final static Logger LOGGER = Logger.getLogger(MovieDAO.class);
	private static final String URL_API = "https://jsonmock.hackerrank.com/api/movies/search?Title=movie_name&page=1";

	public List<Movie> listFromUrl(String nameSubstr) throws Exception {
		try {
			String sUrl = URL_API.replace("movie_name", nameSubstr);
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

			List<Movie> movies = new Gson().fromJson(jMovies.toString(), new TypeToken<List<Movie>>() {}.getType());
			
			LOGGER.info("Found " + movies.size() + " movies with the query " + nameSubstr);
			
			return movies;
		} catch (Exception e) {
			LOGGER.error("Oops! Something happened! Contact the artis... I mean, the developers.", e);
			throw e;
		}
	}
}