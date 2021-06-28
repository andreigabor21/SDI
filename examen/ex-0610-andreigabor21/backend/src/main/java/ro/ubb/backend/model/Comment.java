package ro.ubb.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity<Long> {
    private String text;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Post post;
}
