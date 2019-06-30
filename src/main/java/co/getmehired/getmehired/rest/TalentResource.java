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
import lombok.AllArgsConstructor;


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
//			TalentDTO dto = new TalentDTO();
//			dto.setId(t.getId());
//			dto.setName(t.getName());
//			dto.setEmailAddress(t.getEmailAddress());
//			dto.setPhoneNumber(t.getPhoneNumber());
//			//TODO: HW: add all other fields (use a method)

			TalentDTO dto = new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(), t.getEmailAddress(), t.getTimezone(), null, t.getImmigrationExpiary(),
			t.getAddress(),t.getSsnNumber(),t.getBankAccount(), t.getRoutingNumber(),t.getCitizenship(), t.getImmigrationStatus(), t.getAccademicDegree(),
			t.getDegreeSubject(),t.getGraduationDate(), null, t.getSuuportNeeded(),null, null, null, t.getCuurrentJob(), t.getCurrentEmployer(),
			t.getJobSalary(), t.getNewEmployer(),t.getNewPosition(), t.getJobStartdate(), null);
//			
			talentDTOs.add(dto);
		}
		
		return talentDTOs;
	}

	@GetMapping("/api/talents/{id}")
	public TalentDTO getTalent(@PathVariable String id) {
		
		Talent t = talentService.getTalentById(id).orElseGet(null);
//		Talent t = talentService.getTalentByName(id).orElseGet(null);
		
//		dto.setId(t.getId());
//		dto.setName(t.getName());
//		dto.setEmailAddress(t.getEmailAddress());
//		dto.setPhoneNumber(t.getPhoneNumber());
//		//TODO: HW: add all other fields (use a method)
		
		TalentDTO dto = new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(), t.getEmailAddress(), t.getTimezone(), null, t.getImmigrationExpiary(),
		t.getAddress(),t.getSsnNumber(),t.getBankAccount(), t.getRoutingNumber(),t.getCitizenship(), t.getImmigrationStatus(), t.getAccademicDegree(),
		t.getDegreeSubject(),t.getGraduationDate(), null, t.getSuuportNeeded(),null, null, null, t.getCuurrentJob(), t.getCurrentEmployer(),
		t.getJobSalary(), t.getNewEmployer(),t.getNewPosition(), t.getJobStartdate(), null);
		
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
	public Talent updateTalent(@PathVariable String id, @RequestBody Talent talentInfo) {
		Talent currentTalent = talentService.getTalentById(id).orElseGet(null);
		
		currentTalent.setName(talentInfo.getName());
		currentTalent.setPhoneNumber(talentInfo.getPhoneNumber());
		currentTalent.setEmailAddress(talentInfo.getEmailAddress());
		
		return talentService.save(currentTalent); 
		
		
	}
	


	@DeleteMapping("/api/talents/{id}")
	public void deleteTalent(@PathVariable String id) {
		 this.talentService.deletebyId(id);
	}
	
}