package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.dto.MentorDTO;
import co.getmehired.getmehired.service.MentorService;

@RestController
public class MentorResource {
	
	@Autowired
	private MentorService mentorService;
	
	@PostMapping("/api/mentors")
	public Mentor saveMentor(@RequestBody Mentor mentor) {
	
		 /// saving the input of mentor in the repository
		mentor=mentorService.saveMentor(mentor);
		return mentor;
	}
	
	@GetMapping("/api/mentors")
	public List<MentorDTO> getMentors(){
		
	    List<MentorDTO> mentor_dtos= new ArrayList<>();
	    List<Mentor> mentors=  mentorService.getMentors();
	    
	    for (Mentor m:mentors) {
	      
	             MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
	    			                  m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
	    			                  m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
	    			                  m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
	             mentor_dtos.add(m_dto);
	    }
	    return mentor_dtos;
	    
    }
	
	@GetMapping("/api/mentors/{id}")
	public MentorDTO getMentorById (@PathVariable String id) {
		Mentor m=mentorService.getMentorsById(id).orElseGet(null);
		//Mentor m=mentorService.getMentorsByName(id).orElseGet(null);
	    MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
                  m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
                  m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
                  m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
	    return m_dto;
		
		
	}
	@PutMapping("/api/mentors/{id}")
	public MentorDTO updateMentor(@PathVariable String id,@RequestBody Mentor m) {
		
		//Mentor old_mentor=mentorService.getMentorsById(id).orElseGet(null);
		try {
			if (mentorService.existMentor(id)) {
				System.out.print(true);
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	    MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
                 m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
                 m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
                 m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
	    mentorService.saveMentor(m);
	    mentorService.removeMentorById(id);
	    return m_dto;	
	}
	
	@DeleteMapping("/api/mentors/{id}")
	public MentorDTO deleteMentor(@PathVariable String id){
      
		Mentor m=mentorService.getMentorsById(id).orElseGet(null);
	    MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
                m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
                m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
                m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
	    mentorService.removeMentorById(id);
	    return m_dto;
	    
	    
	}
	

}
