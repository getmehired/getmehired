package co.getmehired.getmehired.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.repository.MentorRepository;

@Service
public class MentorService {
	
	@Autowired
	private MentorRepository mentorrepository;
	
	public Mentor save(Mentor mentor) {
      
		return mentorrepository.save(mentor);
	}
	
	public List<Mentor> getMentors(){
		return mentorrepository.findAll();
	}
	
	
	

}
