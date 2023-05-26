package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.NONE)
public class STBCreatedOutput{
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "status")
    private Status status;

    public STBCreatedOutput(Long id, Status creationResult) {
        this.id = id;
        this.status = creationResult;
    }
}