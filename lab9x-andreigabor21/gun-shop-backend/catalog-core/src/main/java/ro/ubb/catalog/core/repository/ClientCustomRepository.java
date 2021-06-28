package ro.ubb.catalog.core.repository;

import org.springframework.data.repository.query.Param;
import ro.ubb.catalog.core.model.Client;

import java.util.List;

public interface ClientCustomRepository {

    List<Client> findByGivenName(String name);

    List<Client> findByGivenCity(String city);
}
