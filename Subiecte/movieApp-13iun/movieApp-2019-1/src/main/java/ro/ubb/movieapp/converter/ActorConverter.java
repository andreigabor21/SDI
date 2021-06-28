package ro.ubb.movieapp.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movieapp.dto.ActorDto;
import ro.ubb.movieapp.model.Actor;

@Component
public class ActorConverter extends AbstractConverterBaseEntityConverter<Actor, ActorDto> {
    @Override
    public Actor convertDtoToModel(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setName(actorDto.getName());
        actor.setRating(actorDto.getRating());
        return actor;
    }

    @Override
    public ActorDto convertModelToDto(Actor actor) {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(actor.getId());
        actorDto.setName(actor.getName());
        actorDto.setRating(actor.getRating());
        return actorDto;
    }
}
