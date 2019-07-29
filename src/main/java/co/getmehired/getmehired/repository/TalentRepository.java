package co.getmehired.getmehired.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Talent;

public interface TalentRepository extends MongoRepository<Talent, String> {

	Optional<Talent> findByName(String name);

	Optional<Talent> findByEmailAddress(String email);

	boolean existsByEmailAddress(String email);

}
