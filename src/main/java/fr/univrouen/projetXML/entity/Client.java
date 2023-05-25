package fr.univrouen.projetXML.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    @OneToOne
    private Person person;
    //private List<String> mail = new ArrayList<String>();
    private String telephone;
}