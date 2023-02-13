package ro.iteahome.travelbackend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ro.iteahome.travelbackend.dtos.ClientDTO;
import ro.iteahome.travelbackend.entity.Client;

@Component
public class ClientMapper {


    private final ModelMapper modelMapper = new ModelMapper();

    public ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        modelMapper.map(client, clientDTO);
        return clientDTO;

    }

    public Client toClient(ClientDTO clientDTO) {
        Client client = new Client();
        modelMapper.map(clientDTO, client);
        return client;

    }
}
