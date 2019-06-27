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
import co.getmehired.getmehired.model.Timezone;
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
			dto.setTimezone(t.getTimezone());
			dto.setImmigrationExpiary(t.getImmigrationExpiary());
			dto.setAddress(t.getAddress());
			dto.setSsnNumber(t.getSsnNumber());
			dto.setBankAccount(t.getBankAccount());
			dto.setRoutingNumber(t.getRoutingNumber());
			dto.setCitizenship(t.getCitizenship());
			dto.setImmigrationStatus(t.getImmigrationStatus());
			dto.setAccademicDegree(t.getAccademicDegree());
			dto.setDegreeSubject(t.getDegreeSubject());
			dto.setGraduationDate(t.getGraduationDate());
			dto.setSuuportNeeded(t.getSuuportNeeded());
			dto.setEmploymentStart(t.getEmploymentStart());
			dto.setSalaryStart(t.getSalaryStart());
			dto.setSuuportNeeded(t.getSuuportNeeded());
			dto.setCuurrentJob(t.getCuurrentJob());
			dto.setCurrentEmployer(t.getCurrentEmployer());
			dto.setJobSalary(t.getJobSalary());
			dto.setNewEmployer(t.getNewEmployer());
			dto.setNewPosition(t.getNewPosition());
			dto.setJobStartdate(t.getJobStartdate());
			
			
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
		dto.setTimezone(t.getTimezone());
		dto.setImmigrationExpiary(t.getImmigrationExpiary());
		dto.setAddress(t.getAddress());
		dto.setSsnNumber(t.getSsnNumber());
		dto.setBankAccount(t.getBankAccount());
		dto.setRoutingNumber(t.getRoutingNumber());
		dto.setCitizenship(t.getCitizenship());
		dto.setImmigrationStatus(t.getImmigrationStatus());
		dto.setAccademicDegree(t.getAccademicDegree());
		dto.setDegreeSubject(t.getDegreeSubject());
		dto.setGraduationDate(t.getGraduationDate());
		dto.setSuuportNeeded(t.getSuuportNeeded());
		dto.setEmploymentStart(t.getEmploymentStart());
		dto.setSalaryStart(t.getSalaryStart());
		dto.setSuuportNeeded(t.getSuuportNeeded());
		dto.setCuurrentJob(t.getCuurrentJob());
		dto.setCurrentEmployer(t.getCurrentEmployer());
		dto.setJobSalary(t.getJobSalary());
		dto.setNewEmployer(t.getNewEmployer());
		dto.setNewPosition(t.getNewPosition());
		dto.setJobStartdate(t.getJobStartdate());
		
		
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
	
	
	@PutMapping("/api/talents/{id}")
	public TalentDTO updateTalent(@PathVariable String id, @RequestBody Talent talentinfo) {
		Talent t = talentService.getTalentById(id).orElseGet(null);
		talentinfo.setId(id);
		talentService.save(talentinfo);
		
		return updateTalent(id, talentinfo);		
		
	}
	
	@DeleteMapping("/api/talents/{id}")
	public void deleteTalent(@PathVariable String id) {
		 this.talentService.deletebyId(id);
	}
	
}