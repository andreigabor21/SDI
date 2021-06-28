package ro.ubb.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AuthorDto extends BaseDto{
    private String ssn;
    private String name;
    private String contact;
}
