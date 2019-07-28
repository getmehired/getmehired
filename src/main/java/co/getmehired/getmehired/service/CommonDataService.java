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

	public List<Timezone> getTimezone(String name) {

		List<Timezone> alltimezones=timezonerepository.findAll();
		List<Timezone> matchedtimezones= new ArrayList<>();
		for (Timezone t:alltimezones) {
			if(t.getAbbr().startsWith(name)) {
				matchedtimezones.add(t);
			}		
		}
		return matchedtimezones;		
	}


	public List<Country> getCountry(String name) {

		List<Country> allcountries=countryrepository.findAll();
		List<Country> matchedcountries= new ArrayList<>();
		for (Country c:allcountries) {
			if(c.getName().startsWith(name)) {
				matchedcountries.add(c);
			}		
		}
		return matchedcountries;		
	}



	public List<University> getUniversity(String name) {

		List<University> alluniversities=universityrepository.findAll();
		List<University> matcheduniversities= new ArrayList<>();
		for (University u:alluniversities) {
			if(u.getUniversityName().startsWith(name)) {
				matcheduniversities.add(u);
			}		
		}
		return matcheduniversities;		
	}



}
