package co.getmehired.getmehired.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.getmehired.getmehired.model.Country;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.University;
import co.getmehired.getmehired.repository.CountryRepository;
import co.getmehired.getmehired.repository.TimezoneRepository;
import co.getmehired.getmehired.repository.UniversityRepository;

@Service
public class CommonDataService {
	@Autowired
	private UniversityRepository universityrepository;
	@Autowired
	private CountryRepository countryrepository;
	@Autowired
	private TimezoneRepository timezonerepository;

	public List<Timezone> getTimezone() {

		List<Timezone> allTimezones=timezonerepository.findAll();
		return allTimezones;		
	}


	public List<Country> getCountry() {

		List<Country> allCountries=countryrepository.findAll();
		return allCountries;		
	}



	public List<University> getUniversity(String name) {

		List<University> allUniversities=universityrepository.findAll();
		List<University> matchedUniversities= new ArrayList<>();
		for (University u:allUniversities) {
			if(u.getUniversityName().contains(name)) {
				matchedUniversities.add(u);
			}		
		}
		return matchedUniversities;		
	}



}
