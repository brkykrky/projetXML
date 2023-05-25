package fr.univrouen.projetXML.service;

import fr.univrouen.projetXML.mappers.STBMapper;
import fr.univrouen.projetXML.model.STBCreatedOutput;
import fr.univrouen.projetXML.model.STBInput;
import fr.univrouen.projetXML.model.STBOutput;
import fr.univrouen.projetXML.repository.STBRepository;
import lombok.AllArgsConstructor;
import fr.univrouen.projetXML.entity.STB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class STBService {
    private final STBRepository stbRepository;

    public List<STBOutput> getStbList(){
        return stbRepository.findAll().stream().map(STBMapper::mapToOutput).toList();
    }

    public STBOutput getStb(Long id){
        Optional<STB> result =  stbRepository.findById(id);
        return result.isPresent() ? STBMapper.mapToOutput(result.get()) : null;
    }
    public STBCreatedOutput addStb(STBInput stbDto){
        STB stb = new STB();
        stb.setDescription(stbDto.getDescription());
        stb.setTitle(stbDto.getTitle());
        stb.setDate(stbDto.getDate());
        stb.setClientName(stbDto.getClientName());
        stbRepository.save(stb);
        return new STBCreatedOutput(stb.getId());
    }

    public boolean deleteStb(Long id){
        try{
            stbRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Error delete :: " + e.getMessage());
            return false;
        }
    }
}