package ro.ubb.backend.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.BookDto;
import ro.ubb.backend.model.Book;

@Component
public class BookConverter implements Converter<Book, BookDto> {

    @Autowired
    private AuthorConverter authorConverter;

    @Override
    public Book toModel(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
//        book.setAuthor(book.getAuthor());
        book.setTitle(book.getTitle());
        book.setYear(book.getYear());
        return book;
    }

    @Override
    public BookDto toDTO(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        bookDto.setAuthorDto(authorConverter.toDTO(book.getAuthor()));
        return bookDto;
    }
}
