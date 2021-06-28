package ro.ubb.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.backend.model.Author;
import ro.ubb.backend.model.Book;
import ro.ubb.backend.repository.AuthorRepository;
import ro.ubb.backend.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBooksByAuthorAndYear(Long authorId, Integer year) {
        if(authorId == 0 && year == 0) {
            return bookRepository.findAllWithAuthors();
        }
        else if(authorId == 0) {
            return bookRepository.findAllWithAuthors()
                    .stream()
                    .filter(book -> book.getYear().equals(year))
                    .collect(Collectors.toList());
        } else if (year == 0) {
            return bookRepository.findAllWithAuthors()
                    .stream()
                    .filter(book -> book.getAuthor().getId().equals(authorId))
                    .collect(Collectors.toList());
        }
        return bookRepository.findAllWithAuthors()
                .stream()
                .filter(book -> book.getAuthor().getId().equals(authorId))
                .filter(book -> book.getYear().equals(year))
                .collect(Collectors.toList());
    }

}
