package ro.ubb.movieapp.model;


import lombok.*;

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

    public void deleteActorById(long actorId) {
        actors.removeIf(actor -> actor.getId().equals(actorId));
    }
}
