package fr.univrouen.projetXML.repository;

import fr.univrouen.projetXML.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
