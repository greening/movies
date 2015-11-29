package sr.movies.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    protected String movie_name;
    @NotNull
    protected String image_url;
    @NotNull
    protected BigDecimal rating;
    @NotNull
    protected String description;
    protected Movie() {}
    public Movie(String name, String image, BigDecimal rating, String description) {
    	this.movie_name = name;
    	this.image_url = image;
    	this.rating = rating;
    	this.description = description;
    }
}