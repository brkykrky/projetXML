package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class STBResumeOutput {
    @XmlAttribute(name = "id")
    private Long id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "date")
    private Date date;
    @XmlElement(name = "client")
    private String clientName;
}
