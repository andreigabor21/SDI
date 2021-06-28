package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "gunTypeWithRentals",
                attributeNodes = @NamedAttributeNode(value = "rentals")),
        @NamedEntityGraph(name = "gunTypeWithProvider",
                attributeNodes = @NamedAttributeNode(value = "gunProvider"))
})
@Entity
@Table(name = "gun_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class GunType extends BaseEntity<Long> {

    private String name;

    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private GunProvider gunProvider;


    @OneToMany(mappedBy = "gunType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Rental> rentals = new HashSet<>();


    public Set<Client> getClients() {
        return Collections.unmodifiableSet(
                rentals.stream()
                        .map(Rental::getClient)
                        .collect(Collectors.toSet())
        );
    }

    public void addClient(Client client) {
        Rental rental = new Rental();
        rental.setClient(client);
        rental.setGunType(this);
        rentals.add(rental);
    }

    public void addPrice(Client client, Integer price) {
        Rental rental = new Rental();
        rental.setClient(client);
        rental.setPrice(price);
        rental.setGunType(this);
        rentals.add(rental);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GunType gunType = (GunType) o;
        return Objects.equals(name, gunType.name) && Objects.equals(gunProvider, gunType.gunProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gunProvider);
    }
}

