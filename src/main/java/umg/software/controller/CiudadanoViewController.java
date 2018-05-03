package umg.software.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import umg.software.service.CollectionService;

@Controller
public class CiudadanoViewController {
	
	
	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("ciudadanos", collectionService.findAll());
		
	
		return "home";
	}

	
	@RequestMapping("/prueba")
	public String home2(Model model) {
		
	 model.addAttribute("Prueba", "Hola Deyvid");
	 model.addAttribute("Prueba2", "Hola Deyvid2");
	 
	 List<String> pruebalista = new ArrayList<String>();
	 pruebalista.add("maje");
	 pruebalista.add("popo");
	 pruebalista.add("caca");
	 model.addAttribute("Lista", pruebalista);   
	 
	
		return "prueba";
	}
	
	
	
	
}
