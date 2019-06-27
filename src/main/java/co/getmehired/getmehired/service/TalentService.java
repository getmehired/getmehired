package co.getmehired.getmehired.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.dto.TalentDTO;
import co.getmehired.getmehired.repository.TalentRepository;

@Service
public class TalentService {
	
	@Autowired
	private TalentRepository talentRepository;
	
	public Talent save(Talent talent) {
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(talent.getImmigrationExpiaryStr());
			talent.setImmigrationExpiary(date);
			Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(talent.getGraduationDateStr().toString());
			Date date4=new SimpleDateFormat("dd-MM-yyyy").parse(talent.getJobStartdateStr().toString());
			talent.setGraduationDate(date2);
			talent.setJobStartdate(date4);
		} catch (ParseException e) {
			System.out.println(talent.getImmigrationExpiaryStr());
		}
		
		return talentRepository.save(talent);
	}

	public List<Talent> getTalents() {
		return talentRepository.findAll();
	}

	public Optional<Talent> getTalentById(String id) {
		return talentRepository.findById(id);
	}

	public Optional<Talent> getTalentByName(String id) {
		return talentRepository.findByName(id);
	}

}
