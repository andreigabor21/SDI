package ro.ubb.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.UniqueConstraint;

@Data
@Entity
public class Person extends BaseEntity<Long>{
    @Column(unique = true)
    private String ssn;
    private String name;
}
