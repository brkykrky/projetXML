package fr.univrouen.projetXML.repository;

import fr.univrouen.projetXML.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature,Long> {
}
