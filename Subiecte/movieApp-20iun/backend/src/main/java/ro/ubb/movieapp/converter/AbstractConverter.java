package ro.ubb.movieapp.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<Model, Dto>
        implements Converter<Model, Dto> {

    public List<Dto> convertModelsToDtos(List<Model> models) {
        return models.stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toList());
    }

    public List<Model> convertDtosToModel(List<Dto> dtos) {
        return dtos.stream()
                .map(this::convertDtoToModel)
                .collect(Collectors.toList());
    }
}
