package ro.ubb.gunshop.converter;


import ro.ubb.gunshop.dto.BaseDTO;
import ro.ubb.gunshop.model.BaseEntity;

import java.io.Serializable;

public interface Converter <ID extends Serializable, Model extends BaseEntity<ID>, DTO extends BaseDTO<ID>>{
    Model convertDtoToModel(DTO dto);

    DTO convertModelToDto(Model model);
}
