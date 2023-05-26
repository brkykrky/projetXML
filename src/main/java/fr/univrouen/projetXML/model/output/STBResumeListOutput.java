package fr.univrouen.projetXML.model.output;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@XmlRootElement(name = "stbresumelist")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class STBResumeListOutput {
    @XmlElement(name = "stbresume")
    List<STBResumeOutput> stb;
}
