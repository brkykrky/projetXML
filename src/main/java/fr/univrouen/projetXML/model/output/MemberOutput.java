package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class MemberOutput {
    @XmlElement(name = "person")
    private PersonOutput person;
    @XmlElement(name = "functions")
    private List<String> functions = new ArrayList<String>();
}
