package co.getmehired.getmehired.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.UpdateInfo;

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
	
	
	@PutMapping("/api/talents")
	public UpdateInfo updateTalent(@RequestBody Talent talent) {
		
		UpdateInfo new_info=new UpdateInfo();
        new_info.setName(talent.getName());
        new_info.setSsnNumber(talent.getSsnNumber());
        new_info.setPhoneNumber(talent.getPhoneNumber());
       
        return new_info;	
        }
	 @RequestMapping(value = "/api/talents",method = RequestMethod.DELETE)
	  
	    public Talent deleteTalent( Talent talent) {
		 
	    	talent.setName(null);
	    	talent.setEmailAddress(null);
	    	return talent;
	    }
	
	
	
}