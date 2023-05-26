package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@Data
public class FeatureOutput {
    //Attributes
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "section")
    private int section;
    @XmlElement(name = "number")
    private int number;

    //Elements
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "priority")
    private int priority;
    @XmlElement(name = "delivery")
    private Date delivery;
    @XmlElement(name = "comment")
    private String comment;
}
