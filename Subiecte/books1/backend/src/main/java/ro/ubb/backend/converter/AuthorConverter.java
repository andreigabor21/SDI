package ro.ubb.backend.converter;

import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.AuthorDto;
import ro.ubb.backend.model.Author;

@Component
public class AuthorConverter implements Converter<Author, AuthorDto> {
    @Override
    public Author toModel(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(author.getId());
        return author;
    }

    @Override
    public AuthorDto toDTO(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSsn(author.getSsn());
        authorDto.setContact(author.getContact());
        return authorDto;
    }
}
