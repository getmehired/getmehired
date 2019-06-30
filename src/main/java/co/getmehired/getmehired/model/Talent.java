package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.getmehired.getmehired.validator.UniqueEmailAddress;
import lombok.Data;



@Data
@Document(collection = "talents")
public class Talent {
	
	@Id
	private String id;
	
	@NotBlank (message = "Must Input Names")
	private String name; 
	
	@NotEmpty (message = "Must Input Phone Number")
	private Integer phoneNumber;
	
	@UniqueEmailAddress
	private String emailAddress;
	
	@NotNull (message = "Must Input TimeZone")
	private Timezone timezone;
	
	private String immigrationExpiaryStr;
	
	@NotEmpty
	private Date immigrationExpiary;
	
	@NotBlank(message = "Should provide atleast one address")
	private String address;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	@NotNull(message = "Should provide atleast one bank account number")
	private Integer bankAccount;
	
	@NotNull(message = "Should provide routing number associated with bank account")
	private Integer routingNumber;
	
	@NotEmpty
	private Citizenship citizenship;
	
	@NotEmpty
	private Immigration immigrationStatus;
	
	@NotEmpty
	private Degree accademicDegree;
	
	@NotEmpty
	private String degreeSubject;
	
	@NotEmpty
	private Date graduationDate;
	
	private String graduationDateStr;
	
	private Support supportNeeded;
	
	private Objective objective;
	
	@NotEmpty
	private EmploymentStatus employmentStart;
	
	@NotEmpty
	private Integer salaryStart;
	
	@NotEmpty
	private String cuurrentJob;
	
	@NotEmpty
	private String currentEmployer;
	
	@NotEmpty
	private Integer jobSalary;
	
	@NotEmpty
	private String newEmployer;
	
	@NotEmpty
	private String newPosition;
	
	@NotEmpty
	private Date jobStartdate;
	
	private String jobStartdateStr;
	
}