package fr.univrouen.projetXML.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    @OneToOne
    private Person person;
    private String mail;
    private String telephone;
}