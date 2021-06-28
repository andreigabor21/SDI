package ro.ubb.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.backend.converter.BookConverter;
import ro.ubb.backend.dto.BookDto;
import ro.ubb.backend.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookConverter bookConverter;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getFiltered(@RequestParam Long authorId,
                                                     @RequestParam Integer year) {
        logger.info("getFiltered");
        return new ResponseEntity<>(
                bookConverter.toDTOList(authorService
                        .findBooksByAuthorAndYear(authorId, year)),
                HttpStatus.OK
        );
    }


}
