package ro.ubb.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.backend.model.Person;
import ro.ubb.backend.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getAllPersonsByName(String name) {
        return personRepository.findByNameContaining(name);
    }
}
