package ro.ubb.catalog.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "clientWithRentalsAndGunTypes",
                attributeNodes = @NamedAttributeNode(value = "rentals", subgraph = "rentalWithGunTypes"),
                subgraphs = @NamedSubgraph(name = "rentalWithGunType",
                        attributeNodes = @NamedAttributeNode(value = "gunType")))
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class Client extends BaseEntity<Long> {

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Rental> rentals = new HashSet<>();

    public Set<GunType> getGunTypes() {
        rentals = rentals == null ? new HashSet<>() : rentals;
        return Collections.unmodifiableSet(
                this.rentals.stream().
                        map(Rental::getGunType).
                        collect(Collectors.toSet()));
    }

    public void addGunType(GunType gunType) {
        Rental rental = new Rental();
        rental.setClient(this);
        rental.setGunType(gunType);
        rentals.add(rental);
    }

    public void addGunTypes(Set<GunType> gunTypes) {
        gunTypes.forEach(this::addGunType);
    }

    public void addGunTypeWithPrice(GunType gunType, Integer price) {
        Rental rental = new Rental();
        rental.setGunType(gunType);
        rental.setPrice(price);
        rental.setClient(this);
        rentals.add(rental);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
