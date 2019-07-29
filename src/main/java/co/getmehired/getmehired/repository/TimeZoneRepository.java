package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Timezone;

public interface TimeZoneRepository extends MongoRepository<Timezone, String>{

}
