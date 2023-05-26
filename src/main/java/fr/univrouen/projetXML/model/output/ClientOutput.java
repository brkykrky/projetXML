package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class ClientOutput {
    @XmlElement(name = "entity")
    private String entity;
    @XmlElement(name = "person")
    private PersonOutput person;
    @XmlElement(name = "mail")
    private String mail;
    @XmlElement(name = "telephone")
    private String telephone;
}
