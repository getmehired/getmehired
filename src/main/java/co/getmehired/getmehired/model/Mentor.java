package co.getmehired.getmehired.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="mentors")

public class Mentor {
	@Id
	private String id;
	
	@NotBlank
	private String nameMentor; 
	
	@NotNull
	private Integer phoneNumberMentor;
	
	@NotBlank
	private String emailAddressMentor;
	
	@NotBlank
	private String addressMentor;
	
	
    private String calendlyUrlMentor;
	
	private Timezone timezoneMentor;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	
	private Integer bankAccountMentor;
	

	private Integer routingNumberMentor;
	
	
	private Degree accademicDegreeMentor;
	
	@NotBlank
	private String degreeSubjectMentor;
	
	private String mentorExpertise;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String noteTalent;
	
	private TalentStatus talentStatus;
	
	private String meetingTopic;
	
	
}
	@NotBlank
	private TalentStatus talentStatus;
	
	private String meetingTopic;
	
}