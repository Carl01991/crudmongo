package umg.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import umg.software.entity.Ciudadano;
import umg.software.service.CollectionService;
import umg.software.utils.ResponseData;

@RestController
@RequestMapping(value = "/ciudadano")
public class CiudadanoController {

	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ciudadano> findAllCiudadanos(){
		return collectionService.findAll();
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData createObject(@RequestBody Ciudadano data) {
		ResponseData response = new ResponseData();
			System.out.println(data.toString());
			collectionService.crearCiudadano(data);
			response.setCode(200);
			response.setMessage("Guardado");
		return response;
	}
	

	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData update(@RequestBody Ciudadano data) {
		ResponseData response = new ResponseData();
			System.out.println(data.toString());
			collectionService.crearCiudadano(data);
			response.setCode(200);
			response.setMessage("Guardado");
		return response;
	}	
	
	
	
	
	
	@RequestMapping(value = "/consulta/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ciudadano consulta(@PathVariable String id) {

		System.out.println(id);
		Ciudadano ciudadano = 	collectionService.findById(id);
		
		return ciudadano;
	}

	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String remove(@PathVariable String id) {

		System.out.println(id);
		
		return collectionService.removebyID(id);
	}
		
	
	
	
}
