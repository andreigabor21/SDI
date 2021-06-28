package ro.ubb.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address implements Serializable {
    private String city;
    private String street;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, street);
    }
}
