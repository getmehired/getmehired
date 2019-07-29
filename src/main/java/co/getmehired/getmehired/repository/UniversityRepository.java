package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Universities;

public interface UniversityRepository extends MongoRepository<Universities, String> {

}
