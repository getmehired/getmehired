package co.getmehired.getmehired.repository;

import co.getmehired.getmehired.model.FileMeta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileMeta, String> {

	//TODO add required method
    boolean existsByFileName(String filename);

}
