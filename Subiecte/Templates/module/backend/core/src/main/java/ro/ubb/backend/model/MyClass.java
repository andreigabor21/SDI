package ro.ubb.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyClass extends BaseEntity<Long>{

    private String name;
}
