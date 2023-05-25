package fr.univrouen.projetXML.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class STB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date date;
    private String clientName;
    @OneToOne
    private Client client;
    @OneToOne
    private Team team;
    @OneToOne
    private Features features;
}