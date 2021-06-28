package ro.ubb.gunshop.service;

import ro.ubb.gunshop.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void addClient(String name, Integer years);

    void updateClient(Long id, String name, Integer years);

    void deleteClient(Long id);

    List<Client> getClientsByName(String name);
}
