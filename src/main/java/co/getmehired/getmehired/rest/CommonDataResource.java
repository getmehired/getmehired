package co.getmehired.getmehired.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.getmehired.getmehired.model.Country;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.University;
import co.getmehired.getmehired.service.CommonDataService;

@CrossOrigin
@RestController
public class CommonDataResource {
	@Autowired
	private CommonDataService commondataService;

	@GetMapping("/api/timezones")
	public List<Timezone> getTimezones() {

		return commondataService.getTimezone();
	}

	@GetMapping("/api/countries")
	public List<Country> getCountries() {

		return commondataService.getCountry();
	}

	@GetMapping("/api/universities")
	public List<University> getUniversities(@RequestParam String name) {

		return commondataService.getUniversity(name);	
	}

}
