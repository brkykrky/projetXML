package fr.univrouen.projetXML.service;

import fr.univrouen.projetXML.entity.*;
import fr.univrouen.projetXML.mappers.STBMapper;
import fr.univrouen.projetXML.model.input.FeatureInput;
import fr.univrouen.projetXML.model.input.MemberInput;
import fr.univrouen.projetXML.model.output.STBCreatedOutput;
import fr.univrouen.projetXML.model.input.STBInput;
import fr.univrouen.projetXML.model.output.STBOutput;
import fr.univrouen.projetXML.model.output.Status;
import fr.univrouen.projetXML.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class STBService {
    private final STBRepository stbRepository;
    private final ClientRepository clientRepository;
    private final FeatureRepository featureRepository;
    private final MemberRepository memberRepository;
    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;
    private final FunctionRepository functionRepository;
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
        Client c = new Client();
        c.setEntity(stbDto.getClient().getEntity());
        c.setMail(stbDto.getClient().getMail());
        c.setTelephone(stbDto.getClient().getTelephone());
        Person p = new Person();
        p.setGender(stbDto.getClient().getPerson().getGender());
        p.setLastname(stbDto.getClient().getPerson().getLastname());
        personRepository.save(p);
        c.setPerson(p);
        clientRepository.save(c);
        stb.setClient(c);
        Team t = new Team();
        List<Member> members = new ArrayList<>();
        for(MemberInput mi : stbDto.getTeam().getMembers()){
            Person pe = new Person();
            pe.setGender(mi.getPerson().getGender());
            pe.setLastname(mi.getPerson().getLastname());
            personRepository.save(pe);
            Member m = new Member();
            m.setPerson(pe);
            List<Function> funcs = new ArrayList<>();
            for(String func : mi.getFunctions()){
                Function funct = new Function();
                funct.setValue(func);
                functionRepository.save(funct);
                funcs.add(funct);
            }
            m.setFunctions(funcs);
            memberRepository.save(m);
            members.add(m);
        }
        t.setMembers(members);
        teamRepository.save(t);
        stb.setTeam(t);

        List<Feature> features = new ArrayList<>();
        for(FeatureInput fi : stbDto.getFeatures())
        {
            Feature feature = new Feature();
            feature.setDescription(fi.getDescription());
            feature.setName(fi.getName());
            feature.setNumber(fi.getNumber());
            feature.setComment(fi.getComment());
            feature.setDelivery(fi.getDelivery());
            feature.setSection(fi.getSection());
            feature.setPriority(fi.getPriority());
            featureRepository.save(feature);
            features.add(feature);
        }
        stb.setFeatures(features);
        stbRepository.save(stb);
        return new STBCreatedOutput(stb.getId(), Status.CREATED);
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