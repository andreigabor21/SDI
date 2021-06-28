package ro.ubb.movieapp.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraphs(
        @NamedEntityGraph(name = "movieWithActors",
            attributeNodes = @NamedAttributeNode(value = "actors")))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends BaseEntity<Long>{
    @Column(unique=true)
    private String title;

    private int year;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<Actor> actors;
}
