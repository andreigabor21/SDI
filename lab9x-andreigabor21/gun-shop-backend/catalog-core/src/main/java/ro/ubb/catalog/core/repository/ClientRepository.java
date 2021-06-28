package ro.ubb.catalog.core.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component("ClientCriteriaRepository")
public interface ClientRepository extends Repository<Client, Long>, ClientCustomRepository {

    @Query("select distinct c from Client c")
    @EntityGraph(value = "clientWithRentalsAndGunTypes", type = EntityGraph.EntityGraphType.LOAD)
    List<Client> findAllWithRentalsAndGunTypes();

    @Query("select distinct c from Client c where c.id = :clientId")
    @EntityGraph(value = "clientWithRentalsAndGunTypes", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Client> findByIdWithRentalsAndGunTypes(@Param("clientId") Long clientId);

    List<Client> findClientsByDateOfBirthBefore(LocalDate date);
}
