package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Mentor;

public interface MentorRepository  extends MongoRepository<Mentor, String> {

}
