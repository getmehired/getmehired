package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.getmehired.getmehired.model.Timezone;

public interface TimezoneRepository extends MongoRepository<Timezone, String>{

}
