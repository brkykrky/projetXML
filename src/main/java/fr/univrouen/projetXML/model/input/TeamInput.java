package fr.univrouen.projetXML.model.input;

import fr.univrouen.projetXML.model.output.MemberOutput;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamInput {
    @XmlElement(name = "members")
    private List<MemberInput> members;
}
