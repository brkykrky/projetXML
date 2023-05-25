package fr.univrouen.projetXML.controllers;

import fr.univrouen.projetXML.model.STBCreatedOutput;
import fr.univrouen.projetXML.model.STBInput;
import fr.univrouen.projetXML.model.STBOutput;
import fr.univrouen.projetXML.service.STBService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@AllArgsConstructor
@RestController
public class StbController
{
    private final STBService stbService;
    @RequestMapping(value="/stb23/resume/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STBOutput resumeXml()
    {
        STBInput dto = new STBInput();
        dto.setClientName("Berkay");
        dto.setTitle("new title");
        dto.setDescription("description");
        dto.setDate(new Date());
        stbService.addStb(dto);
        return stbService.getStbList().get(0);
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
        return " ";
    }

    @RequestMapping(value = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getHtml()
    {
        return "";
    }

    @PostMapping(value = "/stb23/insert", consumes = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STBCreatedOutput insert(@RequestBody String flux)
    {
        //ToDo : convert flux, create and return result
        return null;
    }

    @DeleteMapping(value = "/stb23/delete/{id}")
    public @ResponseBody ResponseEntity<STBCreatedOutput> delete(@PathVariable Long id)
    {
        return stbService.deleteStb(id) ? ResponseEntity.ok(new STBCreatedOutput(id)) : ResponseEntity.badRequest().build();
    }
}