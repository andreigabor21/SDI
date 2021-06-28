package ro.ubb.movieapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends BaseEntity<Long>{
    @Column(unique=true)
    private String name;

    private int rating;

    @ManyToOne
    private Movie movie;
}
