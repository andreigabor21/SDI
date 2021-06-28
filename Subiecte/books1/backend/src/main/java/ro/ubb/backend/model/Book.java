package ro.ubb.backend.model;

import lombok.Data;

import javax.persistence.*;

@NamedEntityGraphs(
        @NamedEntityGraph(name = "bookWithAuthor",
                attributeNodes = @NamedAttributeNode("author"))
)
@Entity
@Data
public class Book extends BaseEntity<Long>{
    private String title;
    private Integer year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;
}
