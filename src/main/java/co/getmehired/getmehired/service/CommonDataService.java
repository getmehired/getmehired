package co.getmehired.getmehired.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.getmehired.getmehired.model.Country;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.Universities;
import co.getmehired.getmehired.repository.CountryRepository;
import co.getmehired.getmehired.repository.TimeZoneRepository;
import co.getmehired.getmehired.repository.UniversityRepository;

@Service
public class CommonDataService {
    @Autowired
    private UniversityRepository universityrepository;
    @Autowired
    private CountryRepository countryrepository;
    @Autowired
    private TimeZoneRepository timezonerepository;
    public List<Timezone> getTimezone() {

        List<Timezone> allTimezones=timezonerepository.findAll();
        return allTimezones;        
    }


    public List<Universities> getUniversity(String name) {
        List<Universities> allUniversities=universityrepository.findAll();
        List<Universities> matchedUniversities= new ArrayList<>();
        for (Universities u:allUniversities) {
            if(u.getUniversityName().contains(name)) {
                matchedUniversities.add(u);
            }        
        }
        return matchedUniversities;        
    }

    public List<Country> getCountry() {

        List<Country> allCountries=countryrepository.findAll();
        return allCountries;        
    }
}
