package controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController 
{
	@GetMapping(value = "/",produces = MediaType.TEXT_HTML_VALUE)
	public String index() 
	{
		return "<html>\n" +
				"    <head>\n" +
				"        <title>Projet XML</title>\n" +
				"    </head>\n" +
				"    <body>\n" +
				"        <h1>Projet XML</h1>\n" +
				"        <h3>Version 0.3</h3>\n" +
				"        <p>Berkay KARAKAYA & Badis HAMMADACHE</p>\n" +
				"    </body>\n" +
				"</html>";
	}

	@GetMapping(value = "/help",produces = MediaType.TEXT_HTML_VALUE)
	public String help()
	{
		return "<html><head><title>Title</title></head><body><p>Help page</p></body></html>";
	}
}