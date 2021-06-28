package ro.ubb.gunshop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GunTypeDto extends BaseDTO<Long> {
    private String name;
    private String category;
}
