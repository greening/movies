package sr.movies.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.annotation.*;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.*;
import javax.transaction.UserTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import sr.movies.entity.Movies;

import java.math.BigDecimal;
import sr.movies.entity.Movie;
import org.apache.openejb.api.LocalClient;

@LocalClient
public class EntityTest extends TestCase {

    @EJB
    private Movies movies;
    
	@Resource
	private UserTransaction userTransaction;

	@PersistenceContext
	private EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		p.put("movieDatabase", "new://Resource?type=DataSource");
		p.put("movieDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase.JdbcUrl", "jdbc:hsqldb:mem:movies");

		InitialContext initialContext = new InitialContext(p);

		// Here's the fun part
		initialContext.bind("inject", this);
	}

	@After
	public void tearDown() throws Exception {	}

	@Test
	public void test() throws Exception {

		userTransaction.begin();

		try {
			em.persist(new Movie("Reservoir Dogs", "", new BigDecimal(5.0), "Quentin Tarantino"));
			em.persist(new Movie("Fargo", "", new BigDecimal(5.0), "Joel Coen"));
			em.persist(new Movie("The Big Lebowski", "", new BigDecimal(5.0), "Joel Coen"));

			List<Movie> list = movies.getMovies();
			assertEquals("List.size()", 3, list.size());

			for (Movie movie : list) {
				movies.deleteMovie(movie);
			}

			assertEquals("Movies.getMovies()", 0, movies.getMovies().size());

		} finally {
			userTransaction.commit();
		}
	}

}
