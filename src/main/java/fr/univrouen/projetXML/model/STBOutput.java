package fr.univrouen.projetXML.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STBOutput implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute(name = "id")
    private Long id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    private Date date;
    @XmlElement(name = "clientname")
    private String clientName;

    public STBOutput(Long id, String title, String description, Date date, String clientName){
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.clientName = clientName;
    }
    public STBOutput(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}