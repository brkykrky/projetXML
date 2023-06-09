package fr.univrouen.projetXML.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attributes
    private String name;
    private int section;
    private int number;

    //Elements
    private String description;
    private int priority;
    private Date delivery;
    private String comment;
}