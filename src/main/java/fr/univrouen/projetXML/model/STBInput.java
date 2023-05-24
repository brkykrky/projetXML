package fr.univrouen.projetXML.model;

import lombok.Data;

import java.util.Date;

@Data
public class STBInput {
    private String title;
    private String description;
    private Date date;
    private String clientName;
}
