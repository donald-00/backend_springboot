package examplespring.deb.sa.controller;

import examplespring.deb.sa.entites.Sentiment;
import examplespring.deb.sa.enums.TypeSentiment;
import examplespring.deb.sa.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment",produces = APPLICATION_JSON_VALUE)
public class SentimentController {


    private SentimentService sentimentService;


    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creersentiment(@RequestBody   Sentiment sentiment){
        this.sentimentService.creersentiment(sentiment);

    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercherSentiment(@RequestParam(required = false) TypeSentiment type ){
        return this.sentimentService.rechercherSentiment(type);

    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimerSentiment(@PathVariable  int id){

        this.sentimentService.supprimerSentiment(id);

    }
}
