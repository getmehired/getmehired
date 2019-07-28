package co.getmehired.getmehired.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.getmehired.getmehired.model.Country;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.University;
import co.getmehired.getmehired.service.CommonDataService;

@RestController
public class CommonDataResource {
	@Autowired
	private CommonDataService commondataservice;

	@GetMapping("/api/timezones")
	public List<Timezone> getTimezones(@RequestParam String search) {

		return commondataservice.getTimezone(search);
	}

	@GetMapping("/api/countries")
	public List<Country> getCountries(@RequestParam String search) {

		return commondataservice.getCountry(search);
	}

	@GetMapping("/api/universities")
	public List<University> getUniversities(@RequestParam String search) {

		return commondataservice.getUniversity(search);	
	}

}
