package fr.univrouen.projetXML.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Feature {
    @Id
    private Long id;

    //Attributes
    private String name;
    private int section;
    private int number;

    //Elements
    private String description;
    private int priority;
    private Date date;
    private String comment;
}