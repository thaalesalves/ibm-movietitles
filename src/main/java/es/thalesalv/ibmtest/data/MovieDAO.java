package es.thalesalv.ibmtest.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.thalesalv.ibmtest.model.Movie;

public class MovieDAO {

    private final static Logger LOGGER = Logger.getLogger(MovieDAO.class);
    private static final String URL_API = "https://jsonmock.hackerrank.com/api/movies/search?Title=movie_name";

    public List<Movie> getMovieListFromName(String nameSubstr) throws Exception {
        List<Movie> movies = new ArrayList<Movie>();
        try {

        } catch (Exception e) {
            LOGGER.error("Oops! Something happened! Contact the artis... I mean, the developers.", e);
            throw e;
        }

        return movies;
    }
}