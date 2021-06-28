package ro.ubb.movieapp.converter;

import ro.ubb.movieapp.dto.BaseDto;
import ro.ubb.movieapp.model.BaseEntity;

public interface ConverterBaseEntity<Model extends BaseEntity<Long>, Dto extends BaseDto>
        extends Converter<Model, Dto> {

}
