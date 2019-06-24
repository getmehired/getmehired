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
			Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(talent.getGraduationDateStr().toString());
			Date date4=new SimpleDateFormat("dd-MM-yyyy").parse(talent.getJobStartdateStr().toString());
			talent.setGraduationDate(date2);
			talent.setJobStartdate(date4);
		} catch (ParseException e) {
			System.out.println(talent.getImmigrationExpiaryStr());
		}

		return talent;
	}

	
//	@GetMapping("/api/talents")
//	public List<TalentDTO> getTalents(Talent talent) {
//		return null;
//	}

//	@GetMapping("/api/talents/{id}")
//	public TalentDTO getTalent(@PathVariable String id) {
//		return null;
//	}

	
//	@PutMapping("/api/talents/{id}")
//	public TalentDTO updateTalent(
//			@PathVariable String id,
//			@RequestBody Talent talent) {
//		return null;
//	}
	
//	@DeleteMapping("/api/talents/{id}")
//	public TalentDTO deleteTalent(@PathVariable String id) {
//		return null;
//	}
	
}
