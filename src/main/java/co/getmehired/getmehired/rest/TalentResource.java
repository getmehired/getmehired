package co.getmehired.getmehired.rest;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.UpdateInfo;

@RestController
public class TalentResource {
	
	@PostMapping("/api/talents")
	public Talent saveTalent(@RequestBody Talent talent) {
		
	    try {
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getImmigrationExpiaryStr());
			Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getGraduationDatestr());
			Date date3 = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getJobStartDatestr());
			talent.setImmigrationExpiary(date1);
			talent.setGraduationDate(date2);
			talent.setJobStartDate(date3);
		} catch (ParseException e) {
			System.out.println(talent.getImmigrationExpiaryStr());
			System.out.println(talent.getGraduationDatestr());
			System.out.println(talent.getJobStartDatestr());
			//System.out.println("Invalid Date");
			
		}  
	
      return talent;
}
	
	@PutMapping("/api/talents")
	public UpdateInfo updateinfo(@RequestBody Talent talent) {
		UpdateInfo new_info=new UpdateInfo();
		new_info.setName(talent.getName());
		new_info.setSsnNumber(talent.getSsnNumber());
		
		return new_info;
	}
	
	
   @DeleteMapping("/api/talents")
    public Talent deleteTalent(@RequestBody Talent talent) {
    	return talent;
    }
	





}

