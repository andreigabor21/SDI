package ro.ubb.catalog.core.model;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "gunProviderWithGunTypes",
                attributeNodes = @NamedAttributeNode(value = "gunTypes"))
})
@Entity
@Table(name = "gun_provider")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class GunProvider extends BaseEntity<Long> {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    private String name;

    private String speciality;

    private int reputation;

//    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "gunprovider_id")
    @ToString.Exclude
    private List<GunType> gunTypes = new ArrayList<>();

    @PreRemove
    public void setNoGunProvider() {
        log.trace("setNoGunProvider - setting to null");
        gunTypes.forEach(gt -> gt.setGunProvider(null));
    }

    public void addGunType(GunType gunType){
        gunTypes.add(gunType);
    }

    public void removeGunType(GunType gunType){
        gunTypes.remove(gunType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GunProvider that = (GunProvider) o;
        return reputation == that.reputation && Objects.equals(name, that.name) && Objects.equals(speciality, that.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speciality, reputation);
    }
}
