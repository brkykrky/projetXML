package fr.univrouen.projetXML.model.output;

import fr.univrouen.projetXML.entity.Client;
import fr.univrouen.projetXML.entity.Gender;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class PersonOutput {
    @XmlElement(name = "gender")
    private Gender gender;
    @XmlElement(name = "lastname")
    private String lastname;
}
