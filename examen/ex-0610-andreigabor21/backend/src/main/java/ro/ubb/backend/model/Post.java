package ro.ubb.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity<Long>{
    private String title;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppUser appUser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
}
