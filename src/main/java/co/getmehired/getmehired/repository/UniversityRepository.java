package co.getmehired.getmehired.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import co.getmehired.getmehired.model.University;

public interface UniversityRepository extends MongoRepository<University, String> {
	
}
