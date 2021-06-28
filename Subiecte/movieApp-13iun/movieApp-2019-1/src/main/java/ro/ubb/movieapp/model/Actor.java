package ro.ubb.movieapp.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends BaseEntity<Long>{
    @Column(unique=true)
    private String name;

    private int rating;
}
