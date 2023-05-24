package fr.univrouen.projetXML.mappers;

import fr.univrouen.projetXML.entity.STB;
import fr.univrouen.projetXML.model.STBOutput;

public class STBMapper {
    public static STBOutput mapToOutput(STB stb){
        return new STBOutput(stb.getId(),stb.getTitle(),stb.getDescription(),stb.getDate(),stb.getClientName());
    }
}
