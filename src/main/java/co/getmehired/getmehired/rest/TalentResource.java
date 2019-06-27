package co.getmehired.getmehired.rest;

<<<<<<< HEAD
import java.awt.PageAttributes.MediaType;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.UpdateInfo;

@RestController
@CrossOrigin
public class TalentResource {
	
  @RequestMapping("/api/talents")
	
	@PostMapping()
	public Talent saveTalent(@Valid @RequestBody Talent talent) {
		

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
	 
	@PutMapping("/api/talents/{name}")
	public UpdateInfo updateinfo(@RequestBody Talent talent) {
		UpdateInfo new_info=new UpdateInfo();
		new_info.setName(talent.getName());
		new_info.setSsnNumber(talent.getSsnNumber());
		
		return new_info;
	}
	
	
	//this will delete name and address of the user//
  @RequestMapping(value = "/api/talents",method = RequestMethod.DELETE)
  
    public Talent deleteTalent( Talent talent) {
	 
    	talent.setName(null);
    	talent.setAddress(null);
    	return talent;
    }
	





}

=======
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.dto.TalentDTO;
import co.getmehired.getmehired.service.TalentService;


@RestController
public class TalentResource {
	
	@Autowired
	private TalentService talentService;
	
	@PostMapping("/api/talents")
	public Talent saveTalent(@Validated @RequestBody Talent talent) {
		
		talent = talentService.save(talent);
		return talent;
	
	}

	
	@GetMapping("/api/talents")
	public List<TalentDTO> getTalents() {
		List<TalentDTO> talentDTOs = new ArrayList<>();
		
		List<Talent> talents = talentService.getTalents();
		
		for (Talent t : talents) {
			TalentDTO dto = new TalentDTO();
			dto.setId(t.getId());
			dto.setName(t.getName());
			dto.setEmailAddress(t.getEmailAddress());
			dto.setPhoneNumber(t.getPhoneNumber());
			//TODO: HW: add all other fields (use a method)
			
			talentDTOs.add(dto);
		}
		
		return talentDTOs;
	}

	@GetMapping("/api/talents/{id}")
	public TalentDTO getTalent(@PathVariable String id) {
		
		Talent t = talentService.getTalentById(id).orElseGet(null);
//		Talent t = talentService.getTalentByName(id).orElseGet(null);
		
		TalentDTO dto = new TalentDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setEmailAddress(t.getEmailAddress());
		dto.setPhoneNumber(t.getPhoneNumber());
		//TODO: HW: add all other fields (use a method)
		
		return dto;
	}

//TODO: Homework	
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
>>>>>>> 3bcbf0e4a6c0903f0c3c59ee428a650870fcf51c
