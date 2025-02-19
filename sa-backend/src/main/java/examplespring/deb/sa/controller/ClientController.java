package examplespring.deb.sa.controller;


import examplespring.deb.sa.dto.ClientDTO;
import examplespring.deb.sa.entites.Client;

import examplespring.deb.sa.service.ClientService;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;


import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path ="client")
public class ClientController {

    private  ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){

        this.clientService.creer(client);

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> rechercher(){
        return this.clientService.rechercher();

    }

    // un path variable (explication sur ma fiche )
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client lireunclient(@PathVariable int id){

        return this.clientService.lireunclient(id);
    }


    @ResponseStatus(value = NO_CONTENT)
    @PutMapping(path = "{id}",consumes = APPLICATION_JSON_VALUE)
    public void modifierClient(@PathVariable int id, @RequestBody Client client){

        this.clientService.modifierClient(id,client);
    }




}
