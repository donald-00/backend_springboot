# Springboot  java apps
## Application de gestion d'avis by chillotech  

j'ai fais une premiere API qui va permettre au utilisateur de donner leurs  
d'avis. pour la prise ne main de springboot j'espere que ce sera le debut d'une 
longue aventure en tant qu'apprenti developpeur backend   

### REGLE DE GESTION

*un utilisateur peut donner son avis sur un service ou sur un article
qu'il a acheté nous mettons a la disposition de l'utilisateur une application qui va lui 
permettre de saisir son avis . on pourra alors lui dire si c'est un message 
positif ou négatif en fonction de ce qu'il a entré.*

#### base de donnée avec mariadb ,backend springboot


#### API , COUCHE (SERVICE METIER LIGIQUE ), REPOSITORY 

*le chemin est le suivant, API c'est comme l'entrer de la  maison c'est ou tout
transite pour sortir ou entrer dans le backend la couche metier va traiter les donnée pour pourvoir   dans le repository 
qui a la cahrge de lire et ecrire dans la base de donnée*



## VOICI COMMENT RUN L'APPS

pour lancer l'application on commence par demarrer la base donnée
sur docker . les configuration sont dans  le fichier  docker-compose.yml.
les commandes suivantes seront neccesaire **docker-compose up -d** ensuite
**docker ps -a** enfin on run le code dans l'IDE. plutart docker stop nom_container
poour arreter tout.


**source**  [lien de la video](https://youtu.be/k6Nmt-l1Bzc?si=5mMjpRk6az3SEga1)
 














