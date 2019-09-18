package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
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
			TalentDTO dto= new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),t.getImmigrationExpiary(),
					t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getAccademicDegree(),
					t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSupportNeeded(),t.getObjective(),t.getEmploymentStart(),t.getSalaryStart(),
					t.getCurrentJob(),t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());

			talentDTOs.add(dto);
		}
		return talentDTOs;
	}
		
	@GetMapping("/api/talents/{id}")
	public TalentDTO getTalent(@PathVariable String id) {

		Talent t = talentService.getTalentById(id).orElseGet(null);
		//		Talent t = talentService.getTalentByName(id).orElseGet(null);

		TalentDTO dto=new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),
				t.getImmigrationExpiary(),t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),
				t.getAccademicDegree(),t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSupportNeeded(),t.getObjective(),t.getEmploymentStart(),t.getSalaryStart(),t.getCurrentJob(),
				t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());

		return dto;
	}


//TODO: Homework	
	@PutMapping("/api/talents/{id}")
	
	public TalentDTO updateTalent(@PathVariable String id,@RequestBody Talent t) {
		
		TalentDTO dto= new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),t.getImmigrationExpiary(),
									t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getAccademicDegree(),
									t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSupportNeeded(),t.getObjective(),t.getEmploymentStart(),t.getSalaryStart(),
									t.getCurrentJob(),t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());
		talentService.save(t);
		talentService.removeTalentById(id);
		
		return dto;
	}
	
	@DeleteMapping("/api/talents/{id}")
		public TalentDTO deleteTalent(@PathVariable String id) {
		Talent t= talentService.getTalentById(id).orElseGet(null);
		
		TalentDTO dto= new TalentDTO(t.getId(),t.getName(),t.getPhoneNumber(),t.getEmailAddress(),t.getTimezone(),t.getImmigrationExpiaryStr(),t.getImmigrationExpiary(),
							t.getAddress(),t.getSsnNumber(),t.getBankAccount(),t.getRoutingNumber(),t.getCitizenship(),t.getImmigrationStatus(),t.getAccademicDegree(),
							t.getDegreeSubject(),t.getGraduationDate(),t.getGraduationDateStr(),t.getSupportNeeded(),t.getObjective(),t.getEmploymentStart(),t.getSalaryStart(),
							t.getCurrentJob(),t.getCurrentEmployer(),t.getJobSalary(),t.getNewEmployer(),t.getNewPosition(),t.getJobStartdate(),t.getJobStartdateStr());
		talentService.removeTalentById(id);
		
		
		return dto;
	}
	
}
