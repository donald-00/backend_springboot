package examplespring.deb.sa.entites;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    // on pouvait preciser ici avec les anotations que le client est unique (@column (unique = true ) )
    // mais nous a preferer le faire dans le ClientService
    // on pouvait aussi le faire directement dans le sql lors de la creation de la table: la meilleur facon (dans le sa.sql)
    private String email;

    private String telephone;

    private Date creation;

    @Column(name = "mise_a_jour")
    private Date mise_a_jour;   // la mise




    public Client() {

    }


    public Client(int id, String email, String telephone, Date creation, Date misAjour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.mise_a_jour = mise_a_jour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getMisAjour() {
        return mise_a_jour;
    }

    public void setMisAjour(Date misAjour) {
        this.mise_a_jour = misAjour;
    }
}
