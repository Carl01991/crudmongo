package umg.software.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import umg.software.entity.Ciudadano;
import umg.software.repositoryImpl.CollectionRepositoryCustom;


public class CollectionRepositoryImpl implements CollectionRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Ciudadano findByNameAge(String name, int age) {
		try {
			Query resultQuery = new Query();
			resultQuery.addCriteria(Criteria.where("data.name").is(name).and("data.age").is(age));
			
			Ciudadano result = mongoTemplate.findOne(resultQuery, Ciudadano.class);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ciudadano findById(String id) {
		try {
			Query resultQuery = new Query();
			resultQuery.addCriteria(Criteria.where("id").is(id));
			
			Ciudadano result = mongoTemplate.findOne(resultQuery, Ciudadano.class);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
