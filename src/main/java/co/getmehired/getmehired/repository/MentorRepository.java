package co.getmehired.getmehired.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.getmehired.getmehired.model.Mentor;

@Repository
public interface MentorRepository  extends MongoRepository<Mentor, String> {

	Optional<Mentor> findByName(String name);
	Optional<Mentor> findByEmailAddressMentor(String email);
	boolean existsByEmailAddressMentor(String email);

}
