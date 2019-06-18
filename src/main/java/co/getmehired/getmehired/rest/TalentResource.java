package co.getmehired.getmehired.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.UpdateUserInfo;


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
//	public Talent getTalent(Talent talent) {
//		Talent showTalent = new Talent();
//		showTalent.setName("Jonathan");
//		showTalent.setPhoneNumber(423434434);
//		showTalent.setEmailAddress("kohinoor@getmehired.com");
//		showTalent.setAddress("ChicagoIL");
//		showTalent.setImmigrationExpiaryStr("08-12-2020");
//		showTalent.setGraduationDateStr("03-09-2019");
//		showTalent.setJobStartdateStr("05-03-2019");
//		showTalent.setSsnNumber(312312);
//		showTalent.setBankAccount(75345234);
//		showTalent.setRoutingNumber(324234);
//		showTalent.setDegreeSubject("IndustrialEngineering");
//		showTalent.setSalaryStart(75000);
//		showTalent.setCuurrentJob("DEVELOPER");
//		showTalent.setCurrentEmployer("ZENETA");
//		showTalent.setJobSalary(80000);
//		showTalent.setNewEmployer("FACEBOOK");
//		showTalent.setNewPosition("DEVELOPER");
//		//showTalent.setCitizenship("INDIA");
//		
//		return showTalent;
//	}

	
	//User can update 3 fields, name, phonenumber and emailaddress
	@PutMapping("/api/talents")
	public UpdateUserInfo updateTalent(@RequestBody Talent talentinfo) {
		UpdateUserInfo newshowTalent = new UpdateUserInfo();
		newshowTalent.setName(talentinfo.getName());
		newshowTalent.setPhoneNumber(talentinfo.getPhoneNumber());
		newshowTalent.setEmailAddress(talentinfo.getEmailAddress());
		return newshowTalent;
	}
	
	@DeleteMapping(path = "/api/talents")
	public Talent deleteTalent(Talent talent) {
		return talent;
	}
	
}
