package umg.software.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umg.software.entity.Ciudadano;
import umg.software.repository.CollectionRepository;

public interface CollectionService {
	public List<Ciudadano> findAll();
	public Ciudadano findByNameAge(String name, int age);
	public Ciudadano findById(String id);
	public String removebyID(String id);
	public void updateID(Ciudadano ciudadano);
	public void crearCiudadano(Ciudadano ciudadano);
}

@Service
class CollectionServiceImpl implements CollectionService {
	
	@Autowired
	private CollectionRepository repo;

	@Override
	public List<Ciudadano> findAll() {
		try {

			return repo.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Ciudadano>();
		}
	}
	
	public Ciudadano findByNameAge(String name, int age) {
		try {
			
			Ciudadano find = repo.findByNameAge(name,age);
			return find;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Ciudadano findById(String id) {
try {
			
			Ciudadano find = repo.findById(id);
			return find;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
	
	@Override
	public void crearCiudadano(Ciudadano ciudadano) {
		repo.save(ciudadano);
		
	}

	@Override
	public String removebyID(String id) {
		
		
	try {
			
			Ciudadano find = repo.findById(id);
			repo.delete(find);
			return "eliminado";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateID(Ciudadano ciudadano) {
		repo.save(ciudadano);
	}
	
	

}
