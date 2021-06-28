package ro.ubb.catalog.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.GunProvider;

import java.util.List;
import java.util.Optional;

@Component("GunProviderNativeRepository")
public interface GunProviderRepository extends Repository<GunProvider, Long>, GunProviderCustomRepository {

    @Query("select distinct gunProvider from GunProvider gunProvider")
    @EntityGraph(value = "gunProviderWithGunTypes", type = EntityGraph.EntityGraphType.LOAD)
    List<GunProvider> findAllGunProvidersWithGunTypes();

    @Query("select distinct gunProvider from GunProvider gunProvider where gunProvider.id = :id")
    @EntityGraph(value = "gunProviderWithGunTypes", type = EntityGraph.EntityGraphType.LOAD)
    Optional<GunProvider> findByIdWithGunTypes(@Param("id") Long id);


    List<GunProvider> findByOrderByNameAsc();

    //speciality and reputation greater than
    List<GunProvider> findBySpecialityEqualsAndReputationGreaterThan(String speciality, int reputation);

    List<GunProvider> findAllByReputation(int reputation);
}
