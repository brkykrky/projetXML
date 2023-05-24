package fr.univrouen.projetXML.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STBCreatedOutput implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "id")
    private Long id;
    public STBCreatedOutput(Long id){
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}