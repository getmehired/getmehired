package co.getmehired.getmehired.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;

@RestController
public class TalentRessource {
	
	
	
	
	@PostMapping("/api/talents")
	public Talent saveTalent(@RequestBody Talent talent) { 	
		
		System.out.println(talent.getName());
	    System.out.println(talent.getPhoneNumber());
	    System.out.println(talent.getEmailAddress());
	    System.out.println(talent.getTimezone());
	    System.out.println(talent.getImmigrationExpiaryStr());
	    System.out.println(talent.getCalendlyUrl());
	    System.out.println(talent.getSsnNumber());
	    System.out.println(talent.getBankAccount());
	    System.out.println(talent.getRoutingNumber());
	    System.out.println(talent.getCitizenship());
	    System.out.println(talent.getImmigrationStatus());
	    System.out.println(talent.getDegreeSubject());
	    System.out.println(talent.getGraduationDate());
	    System.out.println(talent.getObjective());
	    System.out.println(talent.getSalaryStart());
	    System.out.println(talent.getCuurrentJob());
	    System.out.println(talent.getCurrentEmployer());
	    System.out.println(talent.getJobStartdate());
	    System.out.println(talent.getJobSalary());
	    System.out.println(talent.getNewEmployer());
	    System.out.println(talent.getNewPosition());
	    System.out.println(talent.getAccademicDegree());
	    System.out.println(talent.getSuuportNeeded());
	    System.out.println(talent.getEmploymentStart());
	
	
	
		 try {
		    	Date date = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getImmigrationExpiaryStr());
		    	talent.setImmigrationExpiary(date);
		    } catch (ParseException e) {
				System.out.println(talent.getImmigrationExpiaryStr());
		    }
      return talent;				
   
 }	
}     
  

	   

    
   
