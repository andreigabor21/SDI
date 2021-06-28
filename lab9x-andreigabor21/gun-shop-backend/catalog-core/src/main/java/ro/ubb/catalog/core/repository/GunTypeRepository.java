package ro.ubb.catalog.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Category;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.model.GunType;

import java.util.List;
import java.util.Optional;

@Component("GunTypeCriteriaRepository")
public interface GunTypeRepository extends Repository<GunType, Long>, GunTypeCustomRepository {

    @Query("select distinct gunType from GunType gunType")
    @EntityGraph(value = "gunTypeWithRentals", type = EntityGraph.EntityGraphType.LOAD)
    List<GunType> findAllGunTypesWithRentals();

    @Query("select distinct gunType from GunType gunType")
    @EntityGraph(value = "gunTypeWithProvider", type = EntityGraph.EntityGraphType.LOAD)
    List<GunType> findAllGunTypesWithProviders();

    @Query("select distinct gunType from GunType gunType where gunType.id = :id")
    @EntityGraph(value = "gunTypeWithRentals", type = EntityGraph.EntityGraphType.LOAD)
    Optional<GunType> findByIdWithRentals(@Param("id") Long id);

    List<GunType> findByCategory(Category category);
}
