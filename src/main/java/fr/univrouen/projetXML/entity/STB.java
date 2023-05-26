package fr.univrouen.projetXML.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class STB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date date;
    @OneToOne
    private Client client;
    @OneToOne
    private Team team;
    @OneToMany
    private List<Feature> features = new ArrayList<Feature>();
}