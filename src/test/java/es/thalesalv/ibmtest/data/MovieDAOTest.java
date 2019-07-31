package es.thalesalv.ibmtest.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.thalesalv.ibmtest.util.Json;
public class MovieDAOTest {

    @Test
    public void testGetJson() throws Exception {
        String sUrl = "https://jsonmock.hackerrank.com/api/movies/search";

        assertEquals("Waterworld", Json.listFromUrl(sUrl).get(0).getTitle());
    }
}