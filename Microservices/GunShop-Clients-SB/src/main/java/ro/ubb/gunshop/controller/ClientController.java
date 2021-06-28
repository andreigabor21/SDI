package ro.ubb.gunshop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.gunshop.converter.ClientConverter;
import ro.ubb.gunshop.dto.ClientDto;
import ro.ubb.gunshop.dto.ClientsDto;
import ro.ubb.gunshop.model.Client;
import ro.ubb.gunshop.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients")
    ClientsDto getAllClients() {
        logger.trace("getAllClients - method entered");
        List<Client> clients = clientService.getAllClients();
        ClientsDto clientsDto = new ClientsDto(clientConverter.convertModelsToDTOs(clients));
        logger.trace("getAllClients: " + clients);
        return clientsDto;
    }

    @RequestMapping(value = "/clients/{name}")
    ClientsDto getClientsByName(@PathVariable String name) {
        logger.trace("getClientsByName - method entered - name: " + name);
        List<Client> clients = clientService.getClientsByName(name);
        ClientsDto clientsDto = new ClientsDto(clientConverter.convertModelsToDTOs(clients));
        logger.trace("getClientsByName: " + clients);
        return clientsDto;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    void addClient(@RequestBody ClientDto clientDto) {
        logger.trace("addClient - method entered - clientDto: " + clientDto);
        Client client = clientConverter.convertDtoToModel(clientDto);
        clientService.addClient(client.getName(), client.getYears());
        logger.trace("addClient - added");
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    void updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        logger.trace("updateClient - method entered - clientDto: " + clientDto);
        Client client = clientConverter.convertDtoToModel(clientDto);
        clientService.updateClient(id, client.getName(), client.getYears());
        logger.trace("updateClient - updated");
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteCat(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
