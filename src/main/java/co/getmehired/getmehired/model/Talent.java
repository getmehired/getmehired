package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@Document(collection = "talents")
@AllArgsConstructor
public class Talent {
	
	@Id
	private String id;
	
	@NotBlank(message = " Must have a name")
	private String name; 
	
	@NotNull(message = " Must have a phone no")
	private Integer phoneNumber;
	
	@NotBlank(message = " Must have a valid email address")
	private String emailAddress;
	
	@NotBlank(message = " Must have a valid address")
	private String address;
	
	@NotBlank(message = " Must have a valid Calendly URL")
    private String calendlyUrl;
	
	private Timezone timezone;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	@NotNull
	private Integer bankAccount;
	
	@NotNull
	private Integer routingNumber;
	

	private Citizenship citizenship;
	

	private Immigration immigrationStatus;
	

	private String immigrationExpiaryStr;
	

	private Date immigrationExpiary;
	
	
	private Degree accademicDegree;
	
	@NotBlank(message = " Must input a  subject")
	private String degreeSubject;
	

	private Date graduationDate;
	

	private String graduationDateStr;
	
	private Support suuportNeeded;
	
	private Objective objective;
	

	private EmploymentStatus employmentStat;
	
	@NotNull
	private Integer salaryStart;
	
	@NotBlank(message = " Must input your current job")
	private String currentJob;
	
	@NotBlank(message = " Must input your current employer")
	private String currentEmployer;
	

	private Date jobStartdate;
	

	private String jobStartdateStr;
	
	@NotNull
	private Integer jobSalary;
	
	@NotBlank(message = " Must input your new job")
	private String newEmployer;
	
	@NotBlank(message = " Must input your new position")
	private String newPosition;
	

	
}
