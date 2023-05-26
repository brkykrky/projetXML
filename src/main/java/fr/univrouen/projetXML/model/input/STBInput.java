package fr.univrouen.projetXML.model.input;

import fr.univrouen.projetXML.model.output.ClientOutput;
import fr.univrouen.projetXML.model.output.FeatureOutput;
import fr.univrouen.projetXML.model.output.TeamOutput;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class STBInput {
    private Long id;
    private String title;
    private String description;
    private Date date;
    private ClientInput client;
    private TeamInput team;
    private List<FeatureInput> features;
}
