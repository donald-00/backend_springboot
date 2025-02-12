package examplespring.deb.sa.service;


import examplespring.deb.sa.entites.Client;
import examplespring.deb.sa.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
        Client clientDansLABDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLABDD == null){
            this.clientRepository.save(client);
        }
    }

    public List<Client> rechercher(){
        return this.clientRepository.findAll();

    }

    public Client lireunclient(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                ()-> new EntityNotFoundException("Client n'existe pas")
        );
    }

    public Client lireOuCreer(Client clientAcreer) {

        Client clientDansLABDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLABDD == null){
            clientDansLABDD = this.clientRepository.save(clientAcreer);
        }
        return clientDansLABDD;
    }

    public void modifierClient(int id, Client client) {
        Client clientDansLaBDD = this.lireunclient(id);  // recupérer le client dans la base de donnée

        if(clientDansLaBDD.getId() == client.getId()){
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBDD);

        }

    }
}
