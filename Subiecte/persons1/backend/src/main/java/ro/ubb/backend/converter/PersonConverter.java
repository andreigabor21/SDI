package ro.ubb.backend.converter;

import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.PersonDto;
import ro.ubb.backend.model.Person;

import java.util.List;

@Component
public class PersonConverter implements Converter<Person, PersonDto> {
    @Override
    public Person toModel(PersonDto personDto) {
        Person person = Person.builder()
                .name(personDto.getName())
                .ssn(personDto.getSsn())
                .build();
        person.setId(personDto.getId());
        return person;
    }

    @Override
    public PersonDto toDTO(Person person) {
        PersonDto build = PersonDto.builder()
                .name(person.getName())
                .ssn(person.getSsn())
                .build();
        build.setId(person.getId());
        return build;
    }

}
