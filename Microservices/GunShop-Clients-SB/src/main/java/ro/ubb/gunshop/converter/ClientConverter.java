package ro.ubb.gunshop.converter;

import org.springframework.stereotype.Component;
import ro.ubb.gunshop.dto.ClientDto;
import ro.ubb.gunshop.model.Client;

@Component
public class ClientConverter extends BaseConverter<Long, Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client model = new Client();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setYears(dto.getYears());
        return model;
    }

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto clientDto = new ClientDto(client.getName(), client.getYears());
        clientDto.setId(client.getId());
        return clientDto;
    }
}
