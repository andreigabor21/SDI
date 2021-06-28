package ro.ubb.movieapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ActorDto extends BaseDto {
    private String name;

    private int rating;
}
