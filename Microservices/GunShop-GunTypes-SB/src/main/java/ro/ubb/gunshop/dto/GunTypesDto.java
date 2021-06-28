package ro.ubb.gunshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GunTypesDto {
    Set<GunTypeDto> gunTypes;
}
