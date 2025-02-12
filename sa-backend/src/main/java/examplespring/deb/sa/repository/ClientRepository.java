package examplespring.deb.sa.repository;


import examplespring.deb.sa.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;


//plus besion d'ajouter  la notation Repository  car JpaRepository contient Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findByEmail(String email);

}
