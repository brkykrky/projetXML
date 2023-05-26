package fr.univrouen.projetXML.controllers;

import fr.univrouen.projetXML.entity.Gender;
import fr.univrouen.projetXML.mappers.STBMapper;
import fr.univrouen.projetXML.model.input.*;
import fr.univrouen.projetXML.model.output.Status;
import fr.univrouen.projetXML.model.output.STBCreatedOutput;
import fr.univrouen.projetXML.model.output.STBOutput;
import fr.univrouen.projetXML.model.output.STBResumeListOutput;
import fr.univrouen.projetXML.service.STBService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class StbController
{
    private final STBService stbService;
    @RequestMapping(value="/stb23/resume/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STBResumeListOutput resumeXml()
    {
        /*STBInput dto = new STBInput();
        dto.setTitle("new title");
        dto.setDescription("description");
        dto.setDate(new Date());
        List<FeatureInput> featureInputList = new ArrayList<>();
        FeatureInput fi = new FeatureInput();
        fi.setName("name");
        fi.setComment("comment");
        fi.setDelivery(new Date());
        fi.setNumber(1);
        fi.setPriority(1);
        fi.setSection(1);
        fi.setDescription("description");
        featureInputList.add(fi);
        dto.setFeatures(featureInputList);
        TeamInput ti = new TeamInput();
        List<MemberInput> members = new ArrayList<>();
        MemberInput mi = new MemberInput();
        List<String> functions = new ArrayList<String>();
        functions.add("funcion1");
        mi.setFunctions(functions);
        PersonInput pi = new PersonInput();
        pi.setLastname("last name");
        pi.setGender(Gender.M);
        mi.setPerson(pi);
        members.add(mi);
        ti.setMembers(members);
        dto.setTeam(ti);
        dto.setDate(new Date());
        ClientInput ci = new ClientInput();
        ci.setEntity("client");
        ci.setTelephone("0666666666");
        ci.setMail("mailmail@mail.com");
        pi = new PersonInput();
        pi.setGender(Gender.M);
        pi.setLastname("last name 2");
        ci.setPerson(pi);
        dto.setClient(ci);
        stbService.addStb(dto);*/
        return STBMapper.mapToOutPut(stbService.getStbList());
    }

    @RequestMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ResponseEntity<STBOutput> getXml(@PathVariable Long id)
    {
        STBOutput result = stbService.getStb(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping(value="/stb23/resume",produces = MediaType.TEXT_HTML_VALUE)
    public String resumeHtml()
    {
        return "";
    }

    @RequestMapping(value = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getHtml()
    {
        return "";
    }

    @PostMapping(value = "/stb23/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody STBCreatedOutput insert(@RequestBody STBInput stbInput)
    {
        return stbService.addStb(stbInput);
    }

    @DeleteMapping(value = "/stb23/delete/{id}")
    public @ResponseBody ResponseEntity<STBCreatedOutput> delete(@PathVariable Long id)
    {
        return stbService.deleteStb(id) ? ResponseEntity.ok(new STBCreatedOutput(id, Status.DELETED))
                : ResponseEntity.badRequest().body(new STBCreatedOutput(id, Status.INVALID));
    }
}