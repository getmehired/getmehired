package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Talent;

public interface TalentRepository extends MongoRepository<Talent, String> {

}
