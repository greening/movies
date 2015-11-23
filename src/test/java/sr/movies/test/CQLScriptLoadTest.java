package sr.movies.test;


import com.datastax.driver.core.ResultSet;
import org.cassandraunit.CassandraCQLUnit;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;

public class CQLScriptLoadTest {

	@Before
	public void before() throws TTransportException, IOException, InterruptedException, ConfigurationException {
		EmbeddedCassandraServerHelper.startEmbeddedCassandra();
	}
    @Rule
    public CassandraCQLUnit cassandraCQLUnit = new CassandraCQLUnit(new ClassPathCQLDataSet("freshtomatoes.cql","freshtomatoes"));

    @Test
    public void should_have_started_and_execute_cql_script() throws Exception {
        ResultSet result = cassandraCQLUnit.session.execute("select rating from movies WHERE movie_name='Furious 7'");
        assertThat(result.iterator().next().getString("value"), is("4.0"));
    }
    @After
    public void after() throws Exception {
    	EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }
}
