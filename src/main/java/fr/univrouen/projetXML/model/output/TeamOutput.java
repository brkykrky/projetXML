package fr.univrouen.projetXML.model.output;

import fr.univrouen.projetXML.model.output.MemberOutput;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class TeamOutput {
    @XmlElement(name = "members")
    private List<MemberOutput> members = new ArrayList<MemberOutput>();
}
