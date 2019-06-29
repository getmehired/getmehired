package co.getmehired.getmehired.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import co.getmehired.getmehired.model.Degree;
import co.getmehired.getmehired.model.TalentStatus;
import co.getmehired.getmehired.model.Timezone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MentorDTO {
    private String id;

	private String nameMentor; 
	

	private Integer phoneNumberMentor;

	private String emailAddressMentor;

	private String addressMentor;
	
	
    private String calendlyUrlMentor;
	
	private Timezone timezoneMentor;
	

	private String ssnNumber;
	
	
	private Integer bankAccountMentor;
	

	private Integer routingNumberMentor;
	
	
	private Degree accademicDegreeMentor;

	private String degreeSubjectMentor;
	
	private String mentorExpertise;
	

	private String name;
	

	private String noteTalent;
	
	private TalentStatus talentStatus;
	
	private String meetingTopic;

}
