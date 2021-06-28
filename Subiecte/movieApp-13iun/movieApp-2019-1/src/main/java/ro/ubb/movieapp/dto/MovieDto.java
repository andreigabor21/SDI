package ro.ubb.movieapp.dto;

import lombok.*;
import ro.ubb.movieapp.model.Actor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieDto extends BaseDto{
    private String title;

    private int year;

    private List<Actor> actors;
}
