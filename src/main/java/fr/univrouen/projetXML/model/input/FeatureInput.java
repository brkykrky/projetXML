package fr.univrouen.projetXML.model.input;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.Date;

@Data
public class FeatureInput {
    private String name;
    private int section;
    private int number;

    //Elements
    private String description;
    private int priority;
    private Date delivery;
    private String comment;
}
