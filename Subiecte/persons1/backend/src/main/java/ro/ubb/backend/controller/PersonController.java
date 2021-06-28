package ro.ubb.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.backend.converter.PersonConverter;
import ro.ubb.backend.dto.PersonDto;
import ro.ubb.backend.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonConverter personConverter;

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        logger.info("getAllPersons");
        return new ResponseEntity<>(
                personConverter.toDTOList(personService.getAllPersons()),
                HttpStatus.OK
        );
    }

    @GetMapping("/persons-name")
    public ResponseEntity<List<PersonDto>> getAllPersonsByName(@RequestParam String name) {
        logger.info("getAllPersonsByName");
        return new ResponseEntity<>(
                personConverter.toDTOList(personService.getAllPersonsByName(name)),
                HttpStatus.OK
        );
    }
}
