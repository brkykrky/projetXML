package fr.univrouen.projetXML.controllers;

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
				"        <h1>Pjoet XML 2023</h1>\n" +
				"        <h3>Version 1.0</h3>\n" +
				"        <h4>Berkay KARAKAYA & Badis HAMMADACHE</h4>\n" +
				"        <img src=\"http://eriac.univ-rouen.fr/wp-content/uploads/2016/05/logo-univ-rouen-normandie-couleur-300x108.png\" alt =\"logo univ\">\n" +
				"    </body>\n" +
				"</html>";
	}

	@GetMapping(value = "/help", produces = MediaType.TEXT_HTML_VALUE)
	public String help()
	{
		return "";
	}
}