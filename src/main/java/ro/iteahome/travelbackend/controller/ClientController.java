package ro.iteahome.travelbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.iteahome.travelbackend.dtos.ClientDTO;
import ro.iteahome.travelbackend.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.add(clientDTO), HttpStatus.OK);
    }

}
