package co.getmehired.getmehired.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.repository.MentorRepository;

@Service
public class MentorService {
	
	@Autowired
	private MentorRepository mentorrepository;
	
	public Mentor saveMentor(Mentor mentor) {
      
		return mentorrepository.save(mentor);
	}
	
	public boolean existMentor(String id) {
		return mentorrepository.existsById(id);
		
	}
	public List<Mentor> getMentors(){
		return mentorrepository.findAll();
	}
	
	public Optional<Mentor> getMentorsById(String id) {
		return mentorrepository.findById(id);
	}
	 
	public Optional<Mentor> getMentorsByName(String name) {
		return mentorrepository.findByName(name);
	}
	
    public Optional< Mentor> removeMentorById(String id) {
    	Optional<Mentor> m=mentorrepository.findById(id);
        mentorrepository.deleteById(id);    
        //mentorrepository.delete(m);
        return m;
    }
}
