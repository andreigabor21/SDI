package ro.ubb.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDto extends BaseDto {
    private String title;
    private Integer year;
    private AuthorDto authorDto;
}
