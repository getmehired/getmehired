package co.getmehired.getmehired.model;

//import java.io.File;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
//@Document(collection = "talents")
public class Mentor {
	
	@Id
	private String id;
	
	@NotBlank (message= "Must Input Name")
	private String nameMentor; 
	
	@NotEmpty (message= "Must Input Phone Number")
	private Integer phoneNumberMentor;
	
	@NotBlank(message = "Authentic verification id. Must match with the unique user")
	private String emailAddressMentor;
	
	@NotBlank
	private Timezone timezoneMentor;
	
	@NotBlank(message = "Should provide atleast one address")
	private String addressMentor;
	
	private String calendlyUrlMentor;
	
	private String resumeMentor; //For uploading resume File.io has been imported from java module
	
	@NotNull(message = "Should provide atleast one bank account number")
	private Integer bankAccountMentor;
	
	@NotNull(message = "Should provide routing number associated with bank account")
	private Integer routingNumberMentor;
	
	@NotBlank
	private Degree accademicDegreeMentor;
	
	@NotBlank
	private String degreeSubjectMentor;
	
	@NotBlank
	private String degreeInstituteMentor;
	
	@NotBlank
	private String mentorExpertise;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String noteTalent;
	
	@NotBlank
	private TalentStatus talentStatus;
	
	private String meetingTopic;
	
}