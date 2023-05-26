package fr.univrouen.projetXML.model.input;

import fr.univrouen.projetXML.entity.Gender;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class PersonInput {
    private Gender gender;
    private String lastname;
}
