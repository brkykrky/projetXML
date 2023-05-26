package fr.univrouen.projetXML.mappers;

import fr.univrouen.projetXML.entity.*;
import fr.univrouen.projetXML.model.output.*;

import java.util.ArrayList;
import java.util.List;

public class STBMapper {
    public static STBOutput mapToOutput(STB stb){
        STBOutput out = new STBOutput();
        out.setId(stb.getId());
        out.setTitle(stb.getTitle());
        out.setDate(stb.getDate());
        out.setDescription(stb.getDescription());
        out.setTeam(mapToOutput(stb.getTeam()));
        out.setClient(mapToOutput(stb.getClient()));
        List<FeatureOutput> fetures = new ArrayList<FeatureOutput>();
        for(Feature f : stb.getFeatures())
            fetures.add(mapToOutput(f));
        out.setFeatures(fetures);
        return out;
    }

    public static ClientOutput mapToOutput(Client client){
        ClientOutput out = new ClientOutput();
        out.setMail(client.getMail());
        out.setEntity(client.getEntity());
        out.setTelephone(client.getTelephone());
        out.setPerson(mapToOutput(client.getPerson()));
        return out;
    }

    public static PersonOutput mapToOutput(Person person){
        PersonOutput out = new PersonOutput();
        out.setGender(person.getGender());
        out.setLastname(person.getLastname());
        return out;
    }

    public static TeamOutput mapToOutput(Team team){
        TeamOutput out = new TeamOutput();
        List<MemberOutput> members = new ArrayList<MemberOutput>();
        for(Member m : team.getMembers())
            members.add(mapToOutput(m));
        out.setMembers(members);
        return out;
    }

    public static MemberOutput mapToOutput(Member member){
        MemberOutput out = new MemberOutput();
        List<String> functions = new ArrayList<String>();
        for(Function f : member.getFunctions())
            functions.add(f.getValue());
        out.setFunctions(functions);
        out.setPerson(mapToOutput(member.getPerson()));
        return out;
    }

    public static FeatureOutput mapToOutput(Feature feature){
        FeatureOutput out = new FeatureOutput();
        out.setComment(feature.getComment());
        out.setName(feature.getName());
        out.setDelivery(feature.getDelivery());
        out.setDescription(feature.getDescription());
        out.setNumber(feature.getNumber());
        out.setSection(out.getSection());
        out.setPriority(out.getPriority());
        return out;
    }

    public static STBResumeListOutput mapToOutPut(List<STBOutput> stbs){
        List<STBResumeOutput> sros = new ArrayList<>();
        for(STBOutput stb : stbs){
            STBResumeOutput sro = new STBResumeOutput();
            sro.setClientName(stb.getClient().getPerson().getLastname());
            sro.setDescription(stb.getDescription());
            sro.setTitle(stb.getTitle());
            sro.setDate(stb.getDate());
            sro.setId(stb.getId());
            sros.add(sro);
        }
        STBResumeListOutput res = new STBResumeListOutput();
        res.setStb(sros);
        return res;
    }
}
