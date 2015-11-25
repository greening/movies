package sr.movies.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.net.URL;

import org.hsqldb.cmdline.SqlFile;
import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;

import org.hsqldb.jdbc.JDBCConnection;
public class HSQLDBLoadTest {
	public static Connection c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = DriverManager.getConnection("jdbc:hsqldb:mem:movies", "SA", "");
		String resourceName = "movies.sql";
        URL r = HSQLDBLoadTest.class.getClassLoader().getResource(resourceName);
        File file = (r != null? new File(r.getFile()): null);
        if (!file.isFile())
            throw new IOException("SQL resource not present: " + resourceName);
        SqlFile sqlFile = new SqlFile(file);
        sqlFile.setConnection(c);
//        sqlFile.addUserVars(sqlVarMap);
        sqlFile.execute();

//        database = new HsqlDatabase();
//        database.setUp("freshtomatoes");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void selectTest() throws SQLException {
      ResultSet result = c.createStatement().executeQuery("select rating from movies WHERE movie_name='Furious 7'");
      System.out.println("select rating from movies WHERE movie_name='Furious 7', ResultSet is " + (result == null? "NULL" : result.toString()));
	}

}
