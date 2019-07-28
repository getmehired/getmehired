package co.getmehired.getmehired.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.dto.MentorDTO;
import co.getmehired.getmehired.service.MentorService;

@RestController
public class MentorResource {

	@Autowired
	private MentorService mentorService;

	@PostMapping("/api/mentors")
	public Mentor saveMentor(@RequestHeader String idToken,@Validated @RequestBody Mentor mentor) {
		if(!isValidUser(idToken)) {
			return null;
		}
		mentor=mentorService.saveMentor(mentor);
		return mentor;
	}

	@GetMapping("/api/mentors")
	public List<MentorDTO> getMentors(@RequestHeader String idToken){
		
		if(!isValidUser(idToken)) {
			return null;
		}
		
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
	public MentorDTO getMentorById (@RequestHeader String idToken,@PathVariable String id) {
		
		if(!isValidUser(idToken)) {
			return null;
		}
		
		Mentor m=mentorService.getMentorsById(id).orElseGet(null);
		MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
				m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
				m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
				m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
		return m_dto;
	}
	
	@PutMapping("/api/mentors/{id}")
	public MentorDTO updateMentor(@RequestHeader String idToken,@PathVariable String id,@RequestBody Mentor m) {
		
		if(!isValidUser(idToken)) {
			return null;
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
	public MentorDTO deleteMentor(@RequestHeader String idToken,@PathVariable String id){
		
		if(!isValidUser(idToken)) {
			return null;
		}
		
		Mentor m=mentorService.getMentorsById(id).orElseGet(null);
		MentorDTO m_dto=new MentorDTO(m.getId(),m.getNameMentor(),m.getPhoneNumberMentor(),m.getEmailAddressMentor(),
				m.getAddressMentor(),m.getCalendlyUrlMentor(),m.getTimezoneMentor(),m.getSsnNumber(),m.getBankAccountMentor(),
				m.getRoutingNumberMentor(),m.getAccademicDegreeMentor(),m.getDegreeSubjectMentor(),m.getMentorExpertise(),m.getName(),
				m.getNoteTalent(),m.getTalentStatus(),m.getMeetingTopic());
		mentorService.removeMentorById(id);
		return m_dto;
	}
	private boolean isValidUser(String idToken) {
		
		try {
			String uid=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
			String name=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
			String email=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();
		} catch (InterruptedException | ExecutionException e) {
			return false;
		}
		
		return true;
	}

}