package es.thalesalv.ibmtest.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.ibmtest.data.MovieDAO;

@RestController
@RequestMapping(value = "api/movie")
public class MovieController {

	private final static Logger LOGGER = Logger.getLogger(MovieController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/title")
	public List<String> addAuthor(@RequestParam(value = "title") String title) throws Exception {
		try {
			MovieDAO dao = new MovieDAO();
			List<String> movies = dao.listFromUrl(title).stream().map(x -> x.getTitle()).collect(Collectors.toList());
			Collections.sort(movies);

			LOGGER.info("Printing " + movies.size() + " movies");
			
			return movies;
		} catch (Exception e) {
			LOGGER.error("Wow! Something went wrong!", e);
			throw e;
		}
	}
}
