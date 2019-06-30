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

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.dto.MentorDTO;
import co.getmehired.getmehired.service.MentorService;


@RestController
public class MentorResource {
	
	@Autowired
	private MentorService mentorService;
	
	@PostMapping("/api/mentors")
	public Mentor saveMentor(@Validated @RequestBody Mentor mentor) {
		
		mentor = mentorService.save(mentor);
		return mentor;
	
	}


	
	@GetMapping("/api/mentors")
	public List<MentorDTO> getMentors() {
		List<MentorDTO> mentorDTOs = new ArrayList<>();
		
		List<Mentor> mentors = mentorService.getMentors();
		
		for (Mentor m : mentors) {
//			TalentDTO dto = new TalentDTO();
//			dto.setId(t.getId());
//			dto.setName(t.getName());
//			dto.setEmailAddress(t.getEmailAddress());
//			dto.setPhoneNumber(t.getPhoneNumber());
//			//TODO: HW: add all other fields (use a method)

			MentorDTO dto = new MentorDTO(m.getId(),m.getNameMentor(), m.getPhoneNumberMentor(), m.getEmailAddressMentor(), m.getTimezoneMentor(), 
					m.getAddressMentor(), m.getCalendlyUrlMentor(), m.getResumeMentor(), m.getBankAccountMentor(), m.getRoutingNumberMentor(),
					m.getAccademicDegreeMentor(), m.getDegreeSubjectMentor(), m.getDegreeInstituteMentor(), m.getMentorExpertise(), m.getName(), 
					m.getNoteTalent(), m.getTalentStatus(), m.getMeetingTopic());
//			
			mentorDTOs.add(dto);
		}
		
		return mentorDTOs;
	}

	@GetMapping("/api/mentors/{id}")
	public MentorDTO getMentors(@PathVariable String id) {
		
		Mentor m = mentorService.getMentorById(id).orElseGet(null);
//		Talent t = talentService.getTalentByName(id).orElseGet(null);
		
//		dto.setId(t.getId());
//		dto.setName(t.getName());
//		dto.setEmailAddress(t.getEmailAddress());
//		dto.setPhoneNumber(t.getPhoneNumber());
//		//TODO: HW: add all other fields (use a method)
		
		MentorDTO dto = new MentorDTO(m.getId(),m.getNameMentor(), m.getPhoneNumberMentor(), m.getEmailAddressMentor(), m.getTimezoneMentor(), 
				m.getAddressMentor(), m.getCalendlyUrlMentor(), m.getResumeMentor(), m.getBankAccountMentor(), m.getRoutingNumberMentor(),
				m.getAccademicDegreeMentor(), m.getDegreeSubjectMentor(), m.getDegreeInstituteMentor(), m.getMentorExpertise(), m.getName(), 
				m.getNoteTalent(), m.getTalentStatus(), m.getMeetingTopic());
		
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
	
	//User can update only three fields
	@PutMapping("/api/mentors/{id}")
	public Mentor updateMentor(@PathVariable String id, @RequestBody Mentor mentorInfo) {
		Mentor currentMentor = mentorService.getMentorById(id).orElseGet(null);
		
		try {
			currentMentor.setNameMentor(mentorInfo.getNameMentor());;
			currentMentor.setPhoneNumberMentor(mentorInfo.getPhoneNumberMentor());
			currentMentor.setEmailAddressMentor(mentorInfo.getEmailAddressMentor());
		} catch (IllegalArgumentException e) {
			System.out.println("ID is invalid");
		}
		
		return mentorService.save(currentMentor); 
		
		
	}
	

	@DeleteMapping("/api/mentors/{id}")
	public void deleteMentor(@PathVariable String id) {
		 this.mentorService.deletebyId(id);
	}
	
}