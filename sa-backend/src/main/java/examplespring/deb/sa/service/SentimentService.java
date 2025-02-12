package examplespring.deb.sa.service;


import examplespring.deb.sa.entites.Client;
import examplespring.deb.sa.entites.Sentiment;
import examplespring.deb.sa.enums.TypeSentiment;
import examplespring.deb.sa.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creersentiment(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        // Analyser le sentiment s'il est positif ou negatif. une autre methode
        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);

    }

    public List<Sentiment> rechercherSentiment(TypeSentiment type) {
        if (type == null){

            return  this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);

        }

    }

    public void supprimerSentiment(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
