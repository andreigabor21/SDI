package ro.ubb.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Author extends Person{
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    List<Book> books;
}
