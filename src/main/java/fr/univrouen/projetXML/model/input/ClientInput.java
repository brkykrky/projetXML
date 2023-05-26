package fr.univrouen.projetXML.model.input;

import fr.univrouen.projetXML.model.output.PersonOutput;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class ClientInput {
    private String entity;
    private PersonInput person;
    private String mail;
    private String telephone;
}
