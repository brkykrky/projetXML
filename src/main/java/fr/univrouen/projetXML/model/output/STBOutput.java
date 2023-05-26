package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class STBOutput implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute(name = "id")
    private Long id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "date")
    private Date date;
    @XmlElement(name = "client")
    private ClientOutput client;
    @XmlElement(name = "team")
    private TeamOutput team;
    @XmlElement(name = "features")
    private List<FeatureOutput> features;
}