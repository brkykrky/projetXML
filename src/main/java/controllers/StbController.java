package controllers;

import model.STB;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("/stb23")
public class StbController
{
    @GetMapping(value="/resume/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody STB resumeXml()
    {
        return new STB();
    }

    @GetMapping(value="/resume",produces = MediaType.TEXT_HTML_VALUE)
    public String resumeHtml()
    {
        return " ";
    }
}