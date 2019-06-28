package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Talent saveTalent(@Validated  @RequestBody Talent talent) {
		
		talent = talentService.save(talent);
		return talent;
	
	}

	@GetMapping("/api/talents")
	public List<TalentDTO> getTalents() {
		
		List<TalentDTO> talentDTOs = new ArrayList<>();
		
		List<Talent> talents = talentService.getTalents();
		
		for (Talent t : talents) {
	    TalentDTO dto = new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),
					t.getAddress(),t.getCalendlyUrl(),t.getTimezone(),t.getSsnNumber(),t.getBankAccount(),
					t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getImmigrationExpiary(),
					t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getSuuportNeeded(),t.getObjective(),
					t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),t.getCurrentEmployer(),t.getJobStartdate(),
					t.getJobSalary(),t.getNewEmployer(),t.getNewPosition());
			//dto.setId(t.getId());
			//dto.setName(t.getName());
			//dto.setEmailAddress(t.getEmailAddress());
			//dto.setPhoneNumber(t.getPhoneNumber());
			//TODO: HW: add all other fields (use a method)
			
			talentDTOs.add(dto);
		}
		//System.out.print("hommeeee");
		return talentDTOs;
	}

	@GetMapping("/api/talents/{id}")
	public TalentDTO getTalent(@PathVariable String id) {
		
		Talent t = talentService.getTalentById(id).orElseGet(null);
//		Talent t = talentService.getTalentByName(id).orElseGet(null);
		
		TalentDTO dto =new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),
				t.getAddress(),t.getCalendlyUrl(),t.getTimezone(),t.getSsnNumber(),t.getBankAccount(),
				t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getImmigrationExpiary(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getSuuportNeeded(),t.getObjective(),
				t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),t.getCurrentEmployer(),t.getJobStartdate(),
				t.getJobSalary(),t.getNewEmployer(),t.getNewPosition());
		//dto.setId(t.getId());
		///dto.setName(t.getName());
		//dto.setEmailAddress(t.getEmailAddress());
		//dto.setPhoneNumber(t.getPhoneNumber());
		//TODO: HW: add all other fields (use a method)
		System.out.print("hommeeee  id");
		return dto;
	}

//TODO: Homework	
	@PutMapping("/api/talents/{id}")
	public TalentDTO updateTalent(@PathVariable String id,@RequestBody Talent t) {
	  Talent old_talent = talentService.getTalentById(id).orElseGet(null);
	  /// making a dto talent from new talent
	  TalentDTO t_dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),
				t.getAddress(),t.getCalendlyUrl(),t.getTimezone(),t.getSsnNumber(),t.getBankAccount(),
				t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getImmigrationExpiary(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getSuuportNeeded(),t.getObjective(),
				t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),t.getCurrentEmployer(),t.getJobStartdate(),
				t.getJobSalary(),t.getNewEmployer(),t.getNewPosition());
	  // saving the new talent in repo 
	    talentService.save(t);
	    talentService.removeTalentById(id);
	    return t_dto;
	   
		
	}
	
   @DeleteMapping("/api/talents/{id}")
	public TalentDTO deleteTalent(@PathVariable String id) {
	   
	   // search in the repo which talent matches the given id and make a talent
	   Talent t = talentService.getTalentById(id).orElseGet(null);
	 /// making a dto talent from that talent
	   TalentDTO t_dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),
					t.getAddress(),t.getCalendlyUrl(),t.getTimezone(),t.getSsnNumber(),t.getBankAccount(),
					t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getImmigrationExpiary(),
					t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getSuuportNeeded(),t.getObjective(),
					t.getEmploymentStat(),t.getSalaryStart(),t.getCurrentJob(),t.getCurrentEmployer(),t.getJobStartdate(),
					t.getJobSalary(),t.getNewEmployer(),t.getNewPosition());
	   
	   /// delete the talent from repo
	   talentService.removeTalentById(id);
		return t_dto;
	}
	
}
