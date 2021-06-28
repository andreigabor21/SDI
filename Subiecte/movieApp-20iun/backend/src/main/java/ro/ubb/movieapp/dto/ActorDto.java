package ro.ubb.movieapp.dto;

import ro.ubb.movieapp.model.Movie;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ActorDto extends BaseDto{
    private String name;

    private int rating;
}
