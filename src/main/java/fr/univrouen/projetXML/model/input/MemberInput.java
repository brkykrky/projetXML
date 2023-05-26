package fr.univrouen.projetXML.model.input;

import fr.univrouen.projetXML.model.output.PersonOutput;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberInput {
    private PersonInput person;
    private List<String> functions;
}
