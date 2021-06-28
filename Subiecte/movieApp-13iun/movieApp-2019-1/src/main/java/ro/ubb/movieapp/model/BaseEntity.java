package ro.ubb.movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue
    private ID id;

}
