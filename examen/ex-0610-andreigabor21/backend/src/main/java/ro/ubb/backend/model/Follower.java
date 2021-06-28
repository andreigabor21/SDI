package ro.ubb.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follower extends BaseEntity<Long>{
    private String name;

    private String birthday;

    @Embedded
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppUser appUser;
}
