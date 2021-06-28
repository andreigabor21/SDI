package ro.ubb.gunshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.gunshop.model.Client;
import ro.ubb.gunshop.repository.ClientRepository;

import java.util.List;

import static java.lang.Math.max;

@Service
public class ClientServiceImpl implements ClientService {

    public static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void deleteClient(Long id) {
        logger.trace("deleteClient - method entered - id: " + id);
        clientRepository.findById(id)
                .ifPresent((client) -> clientRepository.deleteById(client.getId()));
        logger.trace("deleteClient - method finished");
    }

    @Override
    @Transactional
    public void updateClient(Long id, String name, Integer years) {
        logger.trace("updateClient - method entered - id: " + id + ", name: " + name + ", years: " + years);
        clientRepository.findById(id)
                .ifPresent((client) -> {
                    client.setName(name);
                    client.setYears(years);
                });
        logger.trace("updateClient - method finished");
    }

    @Override
    public List<Client> getAllClients() {
        logger.trace("getAllClients - method entered");
        List<Client> clients = clientRepository.findAll();
        logger.trace("getAllClients result: " + clients);
        return clients;
    }

    @Override
    public void addClient(String name, Integer years) {
        logger.trace("addClient - method entered");
        long id = 0;
        for (Client client : clientRepository.findAll())
            id = max(id, client.getId() + 1);
        Client newClient = new Client(id, name, years);
        clientRepository.save(newClient);
        logger.trace("addClient - method finished");
    }

    @Override
    public List<Client> getClientsByName(String name) {
        logger.trace("getClientsByName - method entered");
        List<Client> clients = clientRepository.findClientsByName(name);
        logger.trace("getClientsByName - method exited");
        return clients;
    }
}
