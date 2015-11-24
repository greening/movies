package sr.movies.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.DriverManager;
import java.sql.Connection;

import org.junit.runner.RunWith;

import org.hsqldb.jdbc.JDBCConnection;
public class HSQLDBLoadTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:movies", "SA", "");
//        database = new HsqlDatabase();
//        database.setUp("freshtomatoes");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

}
