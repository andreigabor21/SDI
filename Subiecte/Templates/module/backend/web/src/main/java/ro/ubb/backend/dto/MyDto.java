package ro.ubb.backend.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MyDto extends BaseDto{
    private String name;
}
