package umg.software.repositoryImpl;

import umg.software.entity.Ciudadano;

public interface CollectionRepositoryCustom {

	public Ciudadano findByNameAge(String name, int age);
	public Ciudadano findById(String id);
}
