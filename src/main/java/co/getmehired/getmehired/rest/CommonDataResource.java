package co.getmehired.getmehired.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Country;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.University;

@RestController
public class CommonDataResource {
	
	@GetMapping("/api/timezones")
	public List<Timezone> getTimezones() {
		
		return null;
	}
	
	@GetMapping("/api/countries")
	public List<Country> getCountry() {

		return null;
	}
	
	@GetMapping("/api/universities")
	public List<University> getUniversities(@RequestParam String search) {
		
		return null;
	}

}
