package examplespring.deb.sa.repository;

import examplespring.deb.sa.entites.Sentiment;
import examplespring.deb.sa.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

    List<Sentiment> findByType(TypeSentiment  type);


}
