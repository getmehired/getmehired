package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;



public class Mentor {
	@Id
	private String id;
	
	@NotBlank
	private String nameMentor; 
	
	@NotNull
	private Integer phoneNumberMentor;
	
	@NotBlank
	private String emailAddress;
	
	@NotBlank
	private String address;
	

	private Timezone timezone;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	@NotNull
	private Integer bankAccount;
	
	@NotNull
	private Integer routingNumber;
	

	private Citizenship citizenship;
	

	private Immigration immigrationStatus;
	
	@NotNull
	private String immigrationExpiaryStr;
	
	@NotNull
	private Date immigrationExpiary;
	
	
	private Degree accademicDegree;
	
	@NotBlank
	private String degreeSubject;
	
	@NotNull
	private Date graduationDate;
	
	@NotNull
	private String graduationDateStr;
	
	private Support suuportNeeded;
	
	private Objective objective;
	

	private EmploymentStatus employmentStart;
	
	@NotNull
	private Integer salaryStart;
	
	@NotBlank
	private String cuurrentJob;
	
	@NotBlank
	private String currentEmployer;
	
	@NotNull
	private Integer jobSalary;
	
	@NotBlank
	private String newEmployer;
	
	@NotBlank
	private String newPosition;
	
	@NotNull
	private Date jobStartdate;
	
	@NotNull
	private String jobStartdateStr;

}
