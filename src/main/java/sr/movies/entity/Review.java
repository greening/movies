package sr.movies.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Movie movie;
    
    protected BigDecimal rating;
    
    protected String text;
}
