package sr.movies.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Movies resource
 */
@Path("review")
public class Review {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "{\n" + 
        		"    \"visitor_id\": \"1234\",\n" +
        		"    \"movie_id\": \"4321\",\n" + 
        		"    \"rating\": \"4.5\",\n" + 
        		"    \"text\": \"When Tony Stark jumpstarts a dormant peacekeeping program, things go awry and Earth's Mightiest Heroes, including Iron Man, Captain America, Thor, The Incredible Hulk, Black Widow and Hawkeye, are put to the ultimate test as they battle to save the planet from destruction at the hands of the villainous Ultron.\"\n" + 
        		"}";
    }
}
