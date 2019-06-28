package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.getmehired.getmehired.validator.UniqueEmailAddress;
import lombok.Data;

@Data
@Document(collection = "talents")
public class Talent {
	
	@Id
	private String id;
	
	private String name; 
	
	private Integer phoneNumber;
	
	@UniqueEmailAddress
	private String emailAddress;
	
	private Timezone timezone;
	
	private String immigrationExpiaryStr;
	
	private Date immigrationExpiary;
	
	private String address;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	private Integer bankAccount;
	
	private Integer routingNumber;
	
	private Citizenship citizenship;
	
	private Immigration immigrationStatus;
	
	private Degree accademicDegree;
	
	private String degreeSubject;
	
	private Date graduationDate;
	
	private String graduationDateStr;
	
	private Support suuportNeeded;
	
	private Objective objective;
	
	private EmploymentStatus employmentStart;
	
	private Integer salaryStart;
	
	private String cuurrentJob;
	
	private String currentEmployer;
	
	private Integer jobSalary;
	
	private String newEmployer;
	
	private String newPosition;
	
	private Date jobStartdate;
	
	private String jobStartdateStr;
	
}
