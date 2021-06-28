package ro.ubb.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person extends BaseEntity<Long>{

    @Column(unique = true)
    private String ssn;

    private String name;
}
