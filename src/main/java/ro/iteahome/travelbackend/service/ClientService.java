package ro.iteahome.travelbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.iteahome.travelbackend.dtos.ClientDTO;
import ro.iteahome.travelbackend.dtos.mappers.ClientMapper;
import ro.iteahome.travelbackend.entity.Client;
import ro.iteahome.travelbackend.repository.ClientRepository;


@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientRepository clientRepository;

    @PreAuthorize("hasAuthority('CAN_WRITE')")
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @PreAuthorize("hasAuthority('CAN_READ')")
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) clientRepository
                .findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public ClientDTO add(ClientDTO clientDTO) {
        Client receivedClient = clientMapper.toClient(clientDTO);
        Client savedClient = clientRepository.save(receivedClient);
        return clientMapper.toDTO(savedClient);
    }
}
