package co.getmehired.getmehired.repository;

import co.getmehired.getmehired.model.FileMeta;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileMeta, String> {

	//TODO add required method
	void save(Optional<FileMeta> fileMeta);



}
