package co.getmehired.getmehired.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.getmehired.getmehired.model.Country;

public interface CountryRepository extends MongoRepository<Country, String>{ 

}
