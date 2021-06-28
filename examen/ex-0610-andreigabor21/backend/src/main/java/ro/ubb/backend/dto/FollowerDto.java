package ro.ubb.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.backend.model.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowerDto extends BaseDto {
    private String name;
}
