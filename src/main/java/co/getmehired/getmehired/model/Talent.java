package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.getmehired.getmehired.validator.UniqueEmailAddress;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@Document(collection = "talents")
@AllArgsConstructor
public class Talent {

	@Id
	private String id;


	@NotNull(message = " Must have a name Starting with a capital")
	@Pattern(regexp = "^[A-Za-z]*$")
	private String name; 

	@NotNull(message = " Must have a phone no in this format +1-XXX-XXX-XXXX")
	@Pattern(regexp="^\\+[1]{1}-\\d{3}-\\d{3}-\\d{4}$")
	private String phoneNumber;

	@UniqueEmailAddress
	private String emailAddress;

	@NotBlank(message = " Must have a valid address")
	private String address;

	@NotBlank(message = " Must have a valid Calendly URL")
	private String calendlyUrl;

	private TimezoneEnum timezone;

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
