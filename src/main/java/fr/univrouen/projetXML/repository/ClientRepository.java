package fr.univrouen.projetXML.repository;

import fr.univrouen.projetXML.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
