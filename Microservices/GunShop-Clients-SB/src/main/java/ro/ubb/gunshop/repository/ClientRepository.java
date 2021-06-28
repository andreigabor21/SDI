package ro.ubb.gunshop.repository;


import ro.ubb.gunshop.model.Client;

import java.util.List;

public interface ClientRepository extends Repository<Client, Long> {

    List<Client> findClientsByName(String name);
}
