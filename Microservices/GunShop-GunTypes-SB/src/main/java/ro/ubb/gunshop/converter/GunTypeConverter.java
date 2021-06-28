package ro.ubb.gunshop.converter;

import org.springframework.stereotype.Component;
import ro.ubb.gunshop.dto.GunTypeDto;
import ro.ubb.gunshop.model.GunType;

@Component
public class GunTypeConverter extends BaseConverter<Long, GunType, GunTypeDto> {
    @Override
    public GunType convertDtoToModel(GunTypeDto dto) {
        GunType model = new GunType();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setCategory(dto.getCategory());
        return model;
    }

    @Override
    public GunTypeDto convertModelToDto(GunType gunType) {
        GunTypeDto gunTypeDto = new GunTypeDto(gunType.getName(), gunType.getCategory());
        gunTypeDto.setId(gunType.getId());
        return gunTypeDto;
    }
}
