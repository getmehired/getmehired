package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

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
		mentor=mentorService.save(mentor);
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
	
	

}
