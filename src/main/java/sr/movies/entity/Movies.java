package sr.movies.entity;

import java.util.List;

public interface Movies {
    void addMovie(Movie movie) throws Exception ;

    void deleteMovie(Movie movie) throws Exception ;

    List<Movie> getMovies() throws Exception ;
}
