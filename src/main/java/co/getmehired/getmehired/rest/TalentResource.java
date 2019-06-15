package co.getmehired.getmehired.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;

@RestController
public class TalentResource {
	
	@PostMapping("/api/talents")
	public Talent saveTalent(@RequestBody Talent talent) {
		
	    try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getImmigrationExpiaryStr());
			talent.setImmigrationExpiary(date);
		} catch (ParseException e) {
			System.out.println(talent.getImmigrationExpiaryStr());
		}  
		
		return talent;
	}

}
