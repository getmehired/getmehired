package co.getmehired.getmehired.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.dto.MentorDTO;
import co.getmehired.getmehired.repository.MentorRepository;
import co.getmehired.getmehired.repository.TalentRepository;

@Service
public class MentorService {
	
	@Autowired
	private MentorRepository mentorRepository;
	
	public Mentor save(Mentor mentor) {
		return mentorRepository.save(mentor);
	}
	

	public List<Mentor> getMentors() {
		return mentorRepository.findAll();
	}

	public Optional<Mentor> getMentorById(String id) {
		return mentorRepository.findById(id);
	}

	public Optional<Mentor> getMentorByName(String id) {
		return mentorRepository.findByName(id);
	}

	public void deletebyId(String id) {
		 mentorRepository.deleteById(id);
	}

}
