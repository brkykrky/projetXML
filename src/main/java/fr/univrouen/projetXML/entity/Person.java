package fr.univrouen.projetXML.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Gender gender;
    @OneToOne
    private Client client;
    private String lastname;
}