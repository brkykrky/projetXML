package fr.univrouen.projetXML.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Features {
    @Id
    private Long id;

    @OneToMany
    private List<Feature> featureList = new ArrayList<Feature>();
}