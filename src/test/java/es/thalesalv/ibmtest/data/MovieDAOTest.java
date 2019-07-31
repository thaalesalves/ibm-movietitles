package es.thalesalv.ibmtest.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovieDAOTest {

	@Test
	public void testGetJson() throws Exception {
		MovieDAO dao = new MovieDAO();
		assertEquals("Waterworld", dao.listFromUrl("").get(0).getTitle());
	}
}